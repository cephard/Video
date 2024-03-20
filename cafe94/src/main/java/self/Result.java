package self;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Result {

    
     //LoginController data;
   
   @FXML private Text displayUserName;
   // @FXML displayUserName.setText(data.getUserName());
   
   @FXML
    // private void changeName() throws IOException {
       
       
    
    //     //displayUserName.setText(data.getUserName());
    // }
    private void changeName( MouseEvent event) {
        //displayUserName.setText("User");
        displayUserName.setText(LoginController.getUserName());
    }
    
    @FXML
    private void switchToBrowsingPage() throws IOException {
        App.setRoot("menu");
    }
}
