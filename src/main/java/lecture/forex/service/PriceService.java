package lecture.forex.service;

import com.oanda.v20.Context;
import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.InstrumentsCandles;
import lecture.forex.config.Config;
import lecture.forex.model.PriceData;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class PriceService {
    private final Context context;

    public PriceService() {
        context = new Context(Config.getApiUrl(), Config.getApiToken());
    }

    public double getCurrentPrice(String currencyPair) {
        try {
            InstrumentsCandles candles = context.instrument.candles(
                    currencyPair,
                    InstrumentsCandles.CandlestickGranularity.S5,
                    null,
                    1,
                    true
            );

            return candles.getCandles().get(0).getMid().getC().doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public List<PriceData> getHistoricalPrices(String currencyPair, LocalDateTime start, LocalDateTime end) {
        try {
            InstrumentsCandles candles = context.instrument.candles(
                    currencyPair,
                    InstrumentsCandles.CandlestickGranularity.H1,
                    start.toInstant(ZoneOffset.UTC).toString(),
                    end.toInstant(ZoneOffset.UTC).toString(),
                    true
            );

            return candles.getCandles().stream()
                    .map(this::convertToPriceData)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private PriceData convertToPriceData(Candlestick candlestick) {
        return new PriceData(
                LocalDateTime.parse(candlestick.getTime()),
                candlestick.getMid().getO().doubleValue(),
                candlestick.getMid().getH().doubleValue(),
                candlestick.getMid().getL().doubleValue(),
                candlestick.getMid().getC().doubleValue()
        );
    }
}