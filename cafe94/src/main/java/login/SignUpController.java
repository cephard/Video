package login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.*;
import self.App;

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


    ArrayList<String> userData = new ArrayList<>();
    @FXML
    public void switchToSignIn() throws IOException {
      //  if(passwordButton.getText().equals(passwordConfirmButton.getText())) {
//            userData.add(firstNameButton.getText());
//            userData.add(lastNameButton.getText());
//            userData.add(gmailButton.getText());
//            userData.add( addressButton.getText());
//            userData.add(phoneNumberButton.getText());
//            userData.add(passwordButton.getText());
//            String pass = passwordConfirmButton.getText();
        for(int i =0;i<6 ; i++) {
            userData.add("Try1");
        }
            saveNewUserData(userData);
            App.setRoot("login");
//        } else {
//            App.setRoot("loginOrSignupPage");
//        }



    }
//String fName, String lName,String gmail,String address, String pNo, String password
    public static void saveNewUserData(ArrayList<String> userData)  {
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("UserData");

            int r = sheet.getLastRowNum();
            //int l=0;
            Row row = sheet.createRow(r + 1);
            for (int i = 0; i < 6; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(userData.get(i));
                System.out.println("Excel file edited successfully.");
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
