package self;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import login.LoginController;

import java.io.IOException;

public class Result {

    @FXML
    private Button dineIn;
    @FXML
    private Button takeAway;
    @FXML
    private Button delivery;
    //LoginController data;
     @FXML
     private String userName;
     @FXML
     private Text displayUserName;
   // @FXML displayUserName.setText(data.getUserName());
   
    public static String customerType="Ntn";

    LoginController data = LoginController.getInstance();
    @FXML
   public void initialize() {
       displayUserName.setText(data.getUserName());
   }

    private static final Result instance = new Result();
    public static Result getInstance() {
        return instance;
    }

    public String getCustomerType() {
       return this.customerType;
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
    @FXML
    public void switchToDineIn() throws IOException {
        setCustomer("DineIn");
        App.setRoot("menu");
    }

    @FXML
    public void switchToTakeAway() throws IOException {
        setCustomer("TakeAway");
        App.setRoot("menu");
    }
    @FXML
    public void switchToDelivery() throws IOException {
        setCustomer("Delivery");
        App.setRoot("menu");
    }

    public void setCustomer(String type) {
    if(type.equals("DineIn")) {
        this.customerType = type;

    } else if (type.equals("TakeAway")) {
        this.customerType = type;
    }else {
        this.customerType = type;
    }
    }
}
