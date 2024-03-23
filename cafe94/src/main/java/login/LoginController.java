package login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import org.apache.xmlbeans.impl.soap.Text;
import javafx.scene.text.Text;
import self.App;

import java.io.IOException;


public class LoginController {

    protected final String admin_User = "admin";
    protected final String admin_Pass = "admin";
    public static String userName1;
     @FXML private TextField UserNameButton;
    @FXML private TextField passwordButton;
    //@FXML private Label resultBox;
    @FXML private Text loginStatus;
    //static UserData data = new UserData();
static CustomerLoginController data = new CustomerLoginController();



    @FXML
    public void switchToResult() throws IOException {

            String regID = UserNameButton.getText();
            String userPassword = passwordButton.getText();


//                if (data.checkUser(userName) && data.checkUserPass(userPassword)) {
//                    // if (userName.equals(admin_User) && userPassword.equals(admin_Pass)) {
//                    userName1 = userName;
//                    App.setRoot("passResult");
//                } else if (userName.isEmpty() || userPassword.isEmpty()) {
//                    App.setRoot("login");
//                } else {
//                    App.setRoot("result");
//                }
        if (data.checkUserData(regID,userPassword)) {
            // if (userName.equals(admin_User) && userPassword.equals(admin_Pass)) {
            userName1 = regID;
            App.setRoot("passResult");
        } else if (regID.isEmpty() || userPassword.isEmpty()) {
            App.setRoot("login");
        } else {
            loginStatus.setText("Invalid details Try again");
            //App.setRoot("login");
        }


    }

    public static String getUserName(){

        return data.getUserName();
    }
     @FXML
     public void switchToView() throws IOException {
         App.setRoot("view");
     }

     @FXML
    public  void switchToSignUp() throws  IOException{
        App.setRoot("signUpPage");
     }
}
