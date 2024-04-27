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

    opens basket to javafx.fxml;
    exports basket;
}
