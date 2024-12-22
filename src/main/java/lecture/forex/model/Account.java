package lecture.forex.model;

import com.oanda.v20.account.AccountID;

public class Account {
    private final String accountId;
    private final double balance;
    private final double marginAvailable;
    private final double unrealizedPL;

    public Account(AccountID accountId, double balance, double marginAvailable, double unrealizedPL) {
        this.accountId = accountId;
        this.balance = balance;
        this.marginAvailable = marginAvailable;
        this.unrealizedPL = unrealizedPL;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public double getMarginAvailable() {
        return marginAvailable;
    }

    public double getUnrealizedPL() {
        return unrealizedPL;
    }
}