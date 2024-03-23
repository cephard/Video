module self {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens self to javafx.fxml;
    exports self;

    opens login to javafx.fxml;
    exports login;
}
