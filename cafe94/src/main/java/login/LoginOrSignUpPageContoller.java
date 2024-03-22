package login;

import javafx.fxml.FXML;
import self.App;

import java.io.IOException;

public class LoginOrSignUpPageContoller {
    @FXML
    public void switchTologin() throws IOException {
        App.setRoot("login");
    }
    @FXML
    public void switchToSignUp() throws IOException {
        App.setRoot("signUpPage");
    }
}
