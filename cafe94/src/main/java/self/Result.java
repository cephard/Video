package self;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import login.LoginController;

import java.io.IOException;

public class Result {


     //LoginController data;
     public String userName;
   @FXML private Text displayUserName;
   // @FXML displayUserName.setText(data.getUserName());
   

    LoginController data = LoginController.getInstance();
@FXML
   public void initialize() {
//       displayUserName.setOnAction(e -> {
//           changeName();
//        });
//       displayUserName.setText(userName);
//       System.out.println("here       "+userName);
       displayUserName.setText(data.getUserName());
   }

   @FXML
    public  void setUserName(String userName){
        System.out.println("here 31      "+userName);
       this.userName=userName;
       System.out.println("here 33      "+this.userName);
       //initialize();
    }
    @FXML
    private void switchToBrowsingPage() throws IOException {
        App.setRoot("menu");
    }
}
