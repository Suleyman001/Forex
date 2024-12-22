package lecture.forex.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PositionController {

    @FXML
    private ComboBox<String> currencyPairDropdown;

    @FXML
    private TextField quantityField;

    @FXML
    private ComboBox<String> directionDropdown;

    @FXML
    private Label resultLabel;

    @FXML
    private void initialize() {
        // Populate the currency pair dropdown
        currencyPairDropdown.setItems(FXCollections.observableArrayList(
                "EUR/USD", "USD/JPY", "GBP/USD", "AUD/USD", "USD/CHF"
        ));

        // Populate the direction dropdown
        directionDropdown.setItems(FXCollections.observableArrayList("Buy", "Sell"));
    }

    @FXML
    private void positionOpeningAction() {
        // Handle the Open Position button click
        String currencyPair = currencyPairDropdown.getValue();
        String direction = directionDropdown.getValue();
        String quantityText = quantityField.getText();

        if (currencyPair == null || direction == null || quantityText.isEmpty()) {
            resultLabel.setText("Please fill in all fields.");
            return;
        }

        try {
            double quantity = Double.parseDouble(quantityText);
            resultLabel.setText(String.format("Opening %s position for %s with quantity %.2f",
                    direction, currencyPair, quantity));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid quantity. Please enter a valid number.");
        }
    }

    @FXML
    private void positionClosingAction() {
        // Handle the Close Position button click
        resultLabel.setText("Closing position...");
    }

    @FXML
    private void openedPositionsAction() {
        // Handle the View Opened Positions button click
        resultLabel.setText("Fetching opened positions...");
    }
}