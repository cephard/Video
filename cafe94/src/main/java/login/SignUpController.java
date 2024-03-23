package login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.*;
import self.App;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    String pass = "success full ...plz LogIn";
    String fail = " Password doesn't match please try again..!!!";

    @FXML
    public void switchToSignIn() throws IOException {
        if(passwordButton.getText().equals(passwordConfirmButton.getText())) {
            userData.add("CafeMate000");
            userData.add(firstNameButton.getText());
            userData.add(lastNameButton.getText());
            userData.add(gmailButton.getText());
            userData.add( addressButton.getText());
            userData.add(phoneNumberButton.getText());
            userData.add(passwordButton.getText());

            saveNewUserData(userData);
             displayPasswordStatus.setText(pass);
            App.setRoot("login");
        } else {

            displayPasswordStatus.setText(fail);
           //App.setRoot("signUpPage");
        }



    }
//String fName, String lName,String gmail,String address, String pNo, String password
    public static void saveNewUserData(ArrayList<String> userData)  {
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("UserData");

            int r = sheet.getLastRowNum() +1;
            //int l=0;
            Row row = sheet.createRow(r );
            Cell cell = row.createCell(0);
            String regID = userData.get(0)+r+"";
            cell.setCellValue(regID);
            for (int i = 1; i < 7; i++) {
                 cell = row.createCell(i);
                cell.setCellValue(userData.get(i));
                //System.out.println("Excel file edited successfully.");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            // Close streams
            fileInputStream.close();
            fileOutputStream.close();

            workbook.close();

            //  System.out.println("Excel file edited successfully.");

        } catch (IOException  ex) {
            ex.printStackTrace();
        }
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
