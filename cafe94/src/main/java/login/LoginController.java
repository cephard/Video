package login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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

    private static final LoginController instance = new LoginController();
    public static LoginController getInstance() {
        return instance;
    }

    private static String regID;
    private static String userPassword;
    @FXML
    public void switchToResult() throws IOException {

             this.regID = UserNameButton.getText();
             this.userPassword = passwordButton.getText();


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
         //  setValues();
            App.setRoot("passResult");
        } else if (regID.isEmpty() || userPassword.isEmpty()) {
            App.setRoot("login");
        } else {
            loginStatus.setText("Invalid details Try again");
            //App.setRoot("login");
        }


    }

//public void setValues() throws IOException {
//    //FXMLLoader loader = new FXMLLoader(App.class.getResource("passResult.fxml"));
//    //Result controller = loader.getController();
//    Result controller = new Result();
//    controller.setUserName(getUserName());
//    //MenuController menuController = new MenuController();
// // menuController.setUserName(getUserName());
//}
    public  String getUserName(){
        return data.getUserName();
    }

    public String getUserID(){
        return this.regID;
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
