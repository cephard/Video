package login;

import data.DataManagement;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.*;
import self.App;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class SignUpController {
    @FXML private TextField firstNameButton ;
    @FXML private TextField lastNameButton ;
    @FXML private TextField gmailButton ;
    @FXML private TextField  phoneNumberButton;
    @FXML private TextField addressButton ;
    @FXML private TextField passwordButton ;
    @FXML private TextField  passwordConfirmButton;
    @FXML private Text displayPasswordStatus;

    ArrayList<String> userData = new ArrayList<>();
    String pass = "success full registered...plz LogIn";
    String fail = " Password doesn't match please try again..!!!";
    public final String STAFF_ID_TAG = "CMStaff";
    public  final String CUSTOMER_ID_TAG = "CafeMate000";


    @FXML
    public void switchToSignIn() throws IOException {
        String regID="";
        if(passwordButton.getText().equals(passwordConfirmButton.getText())) {

            userData.add("CafeMate000");
            userData.add(firstNameButton.getText());
            userData.add(lastNameButton.getText());
            userData.add(gmailButton.getText());
            userData.add( addressButton.getText());
            userData.add(phoneNumberButton.getText());
            userData.add(passwordButton.getText());

            regID=saveNewUserData(userData);
             displayPasswordStatus.setText(pass+"\nYour RegisterId is "+regID);
           // App.setRoot("login");
        } else {

            displayPasswordStatus.setText(fail);
           //App.setRoot("signUpPage");
        }
    }
//String fName, String lName,String gmail,String address, String pNo, String password
    public static String saveNewUserData(ArrayList<String> userData)  {
        String regID="";
        DataManagement data = new DataManagement();
        Sheet sheet = data.getSheetData("UserData");

        int r = sheet.getLastRowNum() +1;
        //int l=0;
        Row row = sheet.createRow(r );
        Cell cell = row.createCell(0);
        regID = userData.get(0)+r+"";
        cell.setCellValue(regID);
        for (int i = 1; i < 7; i++) {
             cell = row.createCell(i);
            cell.setCellValue(userData.get(i));
            //System.out.println("Excel file edited successfully.");
        }
        cell = row.createCell(7);
        cell.setCellValue("No");
        data.closeExcel();

        //  System.out.println("Excel file edited successfully.");

        return regID;
    }
    @FXML
    public void switchToLogin() throws IOException {
        App.setRoot("login");
    }
    @FXML
    public void switchToView() throws IOException {
        App.setRoot("view");
    }
}
