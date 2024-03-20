package self;

import java.io.IOException;
import javafx.fxml.FXML;

public class StaffController {

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}
