package lecture.forex.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import lecture.forex.model.Account;
import lecture.forex.service.AccountService;

public class AccountController {

    @FXML
    private TableView<Account> accountTable;

    private final AccountService accountService = new AccountService();

    @FXML
    private void initialize() {
        // Fetch account details and populate the table
        accountTable.setItems(accountService.getAccountDetails());
    }
}