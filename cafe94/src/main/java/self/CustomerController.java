package self;

import java.io.IOException;
import javafx.fxml.FXML;

public class CustomerController {

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

}
