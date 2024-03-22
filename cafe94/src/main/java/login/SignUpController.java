package login;

import javafx.fxml.FXML;
import self.App;

import java.io.IOException;

public class SignUpController {
    @FXML
    public void switchToLogin() throws IOException {
        App.setRoot("login");
    }
    @FXML
    public void switchToView() throws IOException {
        App.setRoot("view");
    }
}
