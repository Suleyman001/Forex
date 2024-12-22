package lecture.forex;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.order.OrderCreateRequest;
import com.oanda.v20.order.OrderCreateResponse;
import com.oanda.v20.primitives.InstrumentName;
import com.oanda.v20.trade.Trade;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.oanda.v20.order.MarketOrderRequest;

import java.util.List;

public class HelloController {
    @FXML private TextArea welcomeText;
    @FXML private ComboBox cb1;
    @FXML private TextField tf1;
    Context ctx;
    AccountID accountId;
    @FXML
    private void initialize()
    {
        cb1.getItems().addAll("EUR_USD", "USD_JPY", "GBP_USD", "EUR_GBP", "AUD_USD", "NZD_USD", "USD_CHF");
        cb1.getSelectionModel().select("EUR_USD");
        ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("PricePolling").build();
        accountId = Config.ACCOUNTID;
    }

    @FXML
    protected void onTradesButtonClick() {
        try {
            List<Trade> trades = ctx.trade.listOpen(accountId).getTrades();
            for(Trade trade: trades)
                welcomeText.setText(welcomeText.getText() + "\n" +trade.getId()+"\t"+trade.getInstrument()+"\t"+trade.getOpenTime()+"\t"+trade.getCurrentUnits()+"\t"+trade.getPrice()+"\t"+trade.getUnrealizedPL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onOpenButtonClick() {
        InstrumentName instrument = new InstrumentName(cb1.getValue().toString());
        try {
            OrderCreateRequest request = new OrderCreateRequest(accountId);
            MarketOrderRequest marketorderrequest = new MarketOrderRequest();
            marketorderrequest.setInstrument(instrument);
            marketorderrequest.setUnits(Integer.parseInt(tf1.getText()));
            request.setOrder(marketorderrequest);
            OrderCreateResponse response = ctx.order.create(request);
            System.out.println("tradeId: "+response.getOrderFillTransaction().getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}