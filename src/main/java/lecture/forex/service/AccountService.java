package lecture.forex.service;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountSummaryResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.forex.model.Account;

public class AccountService {

    private final Context context;

    public AccountService() {
        // Replace with your OANDA API token and URL
        String apiToken = "your-oanda-api-token";
        String apiURL = "https://api-fxpractice.oanda.com";
        this.context = new Context(apiURL, apiToken);
    }

    public ObservableList<Account> getAccountDetails() {
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        try {
            AccountSummaryResponse response = context.account.summary(new com.oanda.v20.account.AccountID("your-account-id"));
            accounts.add(new Account(
                    response.getAccount().getId(),
                    response.getAccount().getBalance().doubleValue(),
                    response.getAccount().getMarginAvailable().doubleValue(),
                    response.getAccount().getUnrealizedPL().doubleValue()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}