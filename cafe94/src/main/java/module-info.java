module self {
    requires javafx.controls;
    requires javafx.fxml;

    opens self to javafx.fxml;
    exports self;
}
