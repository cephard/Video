package self;

import java.util.HashMap;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginController {

    private final String admin_User = "admin";
    private final String admin_Pass = "admin";
    public static String userName1;
     @FXML private TextField UserNameButton;
    @FXML private TextField passwordButton;
    //@FXML private Label resultBox;

    static UserData data = new UserData();

    @FXML
    private void switchToResult() throws IOException {

            String userName = UserNameButton.getText();
            String userPassword = passwordButton.getText();

            if(data.checkUser(userName) && data.checkUserPass(userPassword) ) {
            // if (userName.equals(admin_User) && userPassword.equals(admin_Pass)) {
                userName1=userName;
                App.setRoot("passResult");
            } else {
                App.setRoot("result");
            }

    }

    public static String getUserName(){

        return data.getUserName(userName1);
    }
     @FXML
     private void switchToView() throws IOException {
         App.setRoot("view");
     }
}
