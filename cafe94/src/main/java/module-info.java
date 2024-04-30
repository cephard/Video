module self {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens self to javafx.fxml;
    exports self;

    opens login to javafx.fxml;
    exports login;
    exports customer;
    opens customer to javafx.fxml;
    exports menu;
    opens menu to javafx.fxml;
    exports staff;
    opens staff to javafx.fxml;

    exports report;
    opens report to javafx.fxml;
    opens basket to javafx.fxml;
    exports basket;
    exports transaction;
    exports waiterOrder;
    exports waiterSpecials;

     opens transaction to javafx.fxml;
     opens waiterOrder to  javafx.fxml;
     opens waiterSpecials  to javafx.fxml;
}
