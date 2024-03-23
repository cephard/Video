package login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import self.App;

import java.io.IOException;


public class LoginController {

    protected final String admin_User = "admin";
    protected final String admin_Pass = "admin";
    public static String userName1;
     @FXML private TextField UserNameButton;
    @FXML private TextField passwordButton;
    //@FXML private Label resultBox;

    static UserData data = new UserData();

    @FXML
    public void switchToResult() throws IOException {

            String userName = UserNameButton.getText();
            String userPassword = passwordButton.getText();


                if (data.checkUser(userName) && data.checkUserPass(userPassword)) {
                    // if (userName.equals(admin_User) && userPassword.equals(admin_Pass)) {
                    userName1 = userName;
                    App.setRoot("passResult");
                } else if (userName.isEmpty() || userPassword.isEmpty()) {
                    App.setRoot("login");
                } else {
                    App.setRoot("result");
                }


    }

    public static String getUserName(){

        return data.getUserName(userName1);
    }
     @FXML
     public void switchToView() throws IOException {
         App.setRoot("view");
     }
}
