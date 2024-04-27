/**
 * This class controls the user interface of object Staff
 */

package staff;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import self.App;
import java.io.IOException;
import static staff.StaffDataController.updateClockOut;

public class StaffMemberController {
    private Staff staffMember;
    @FXML
    private Text clockInText;
    @FXML
    private Text nameText;
    @FXML
    private Text roleText;
    @FXML
    private Text shiftText;
    @FXML
    private ImageView imageView;
    @FXML
    StackPane stackPane1;
    @FXML
    StackPane stackPane2;
    @FXML
    StackPane stackPane3;
    @FXML
    StackPane stackPane4;
    @FXML
    StackPane stackPane5;
    @FXML
    StackPane stackPane6;
    @FXML
    StackPane stackPane7;
    @FXML
    StackPane stackPane8;
    @FXML
    StackPane stackPane9;

    /**
     * Loading Staff details from the list of employees in the system
     * setting the employee status to clocked in
     */
    @FXML
        public void initialize() {
            imageView.setOnMouseClicked(event -> {
               switchToDetails();
            });
        staffMember = StaffController.getEmployeeFromStaffList();
            if (staffMember != null) {
                nameText.setText(staffMember.getName());
                roleText.setText(staffMember.getRole());
                shiftText.setText(staffMember.getShift() + " hours");
                clockInText.setText(staffMember.getClockIn());

                if (staffMember.getImagePath() != null && !staffMember.getImagePath().isEmpty()) {
                    Image image = new Image("file:" + staffMember.getImagePath());
                    imageView.setImage(image);
                }
            }
        }


    @FXML
    private void switchToStaff() throws IOException {
        App.setRoot("staff");
    }

    @FXML
    private void switchToMain() throws IOException {
        String attendanceSheet = "cafe94/src/main/resources/self/DataBase/staffAttendance.csv";
        updateClockOut(attendanceSheet,staffMember);
        App.setRoot("view");
    }

    @FXML
    private void switchToDetails() {
        try {
            App.setRoot("staffDetails");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
