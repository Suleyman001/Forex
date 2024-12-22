module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.oanda.v20;
    requires org.slf4j;
    requires java.sql;
    requires gson;
    requires httpcore;
    requires httpclient;
    requires v20;

    opens com.example.demo to javafx.fxml;
    opens com.oanda.v20 to javafx.fxml;
    opens com.oanda.v20.account to javafx.fxml;
    opens com.oanda.v20.pricing to javafx.fxml;
    opens com.oanda.v20.order to javafx.fxml;
    opens com.oanda.v20.instrument to javafx.fxml;
    opens com.oanda.v20.trade to javafx.fxml;
    opens com.oanda.v20.transaction to javafx.fxml;

    exports com.example.demo;
    exports com.oanda.v20.primitives;
    exports com.oanda.v20.transaction;
    exports com.oanda.v20.order;
    exports com.oanda.v20.trade;
}