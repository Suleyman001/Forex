package lecture.forex.model;

public class Position {
    private String currencyPair; // The currency pair, e.g., "EUR/USD"
    private String direction; // The direction of the trade, e.g., "Buy" or "Sell"
    private double quantity; // The quantity of the trade
    private String positionId; // Optional: Unique ID for the position
    private String timestamp; // Optional: Time when the position was opened

    // Constructor for the required fields
    public Position(String currencyPair, String direction, double quantity) {
        this.currencyPair = currencyPair;
        this.direction = direction;
        this.quantity = quantity;
    }

    // Overloaded constructor for optional fields
    public Position(String positionId, String currencyPair, String direction, double quantity, String timestamp) {
        this.positionId = positionId;
        this.currencyPair = currencyPair;
        this.direction = direction;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    // Getters
    public String getCurrencyPair() {
        return currencyPair;
    }

    public String getDirection() {
        return direction;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getPositionId() {
        return positionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // toString Method (Optional: Useful for debugging or logging)
    @Override
    public String toString() {
        return "Position {" +
                "positionId='" + positionId + '\'' +
                ", currencyPair='" + currencyPair + '\'' +
                ", direction='" + direction + '\'' +
                ", quantity=" + quantity +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}