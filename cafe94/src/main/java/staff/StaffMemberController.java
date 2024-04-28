/**
 * This class controls the user interface of object Staff
 */

package staff;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import self.App;
import java.io.IOException;
import static staff.StaffDataController.updateClockOut;

public class StaffMemberController {
    @FXML
    private Label firstRole;
    @FXML
    private Label secondRole;
    @FXML
    private Label thirdRole;
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
    StackPane mainDuty;
    @FXML
    StackPane pendingDuty;
    @FXML
    StackPane dutyInProgress;
    /**
     * Loading Staff details from the list of employees in the system
     * setting the employee status to clocked in
     */
    @FXML
        public void initialize() {
        staffMember = StaffController.getEmployeeFromStaffList();
            if (staffMember != null) {
                nameText.setText(staffMember.getName());
                roleText.setText(staffMember.getRole());
                shiftText.setText(staffMember.getShift() + " hours");
                clockInText.setText(staffMember.getClockIn());

                if (staffMember.getImagePath() != null && !staffMember.getImagePath().isEmpty()) {
                    Image image = new Image("file:" + staffMember.getImagePath());
                    imageView.setImage(image);
                    handleStackPaneClick(staffMember.getRole());
                }
            }
        imageView.setOnMouseClicked(event -> {
            switchToDetails();
        });
        }

    private void handleStackPaneClick(String role) {
        // Set duties based on role using switch statement
        switch (role) {
            case "chef":
                setChefDuties();
                break;
            case "waiter":
                setWaiterDuties();
                break;
            case "deliveryDriver":
                setDriverDuties();
                break;
            default:
                setManagerDuties();
                break;
        }
    }

    private void setManagerDuties() {
        firstRole.setText("Hire Staff");
        secondRole.setText("Fire Staff");
        thirdRole.setText("Check Attendance");
    }

    private void setChefDuties() {
        firstRole.setText("Make Order");
        secondRole.setText("Serve Customer");
        thirdRole.setText("Daily Special");
    }

    private void setDriverDuties() {
        firstRole.setText("Delivered Orders");
        secondRole.setText("Previous Orders");
        thirdRole.setText("Pending Orders");
    }

    private void setWaiterDuties() {
        firstRole.setText("Take Order");
        secondRole.setText("Serve Order");
        thirdRole.setText("Print Receipt");
    }


    @FXML
        private void staffRole(){

        }


    @FXML
    private void switchToStaff() throws IOException {
        App.setRoot("staff");
    }


    /**
     * Method to exit staff portal updates clock out time automatically
     * @throws IOException
     */
    @FXML
    private void switchToMain() throws IOException {
        String attendanceSheet = "cafe94/src/main/resources/self/DataBase/staffAttendance.csv";
        updateClockOut(attendanceSheet,staffMember);
        App.setRoot("view");
    }

    /**
     * Access a specific staff details
     */
    @FXML
    private void switchToDetails() {
        try {
            App.setRoot("staffDetails");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
