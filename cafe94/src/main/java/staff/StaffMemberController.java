/**
 * This class controls the user interface of object Staff
 */

package staff;

import basket.BasketLoader;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import self.App;
import java.io.IOException;
import java.util.ArrayList;

import static staff.StaffDataController.updateClockOut;

public class StaffMemberController {
    @FXML
    public Label forthRole;
    @FXML
    private StackPane secondaryDuty;
    @FXML
    private Text firstRole;
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

    BasketLoader data = new BasketLoader();
    private String userID = "";
    public  String userInfo = "ntn";
    public ArrayList<String> deliveryDetails = new ArrayList<>();
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
        mainDuty.setOnMouseClicked(event -> {
           getOrders();
        });

        pendingDuty.setOnMouseClicked(event -> {
            changeStatus();
        });

        dutyInProgress.setOnMouseClicked(mouseEvent -> {
            switchToReport();
        });

        //making sure only manager can access these roles
        if (staffMember.getRole().equalsIgnoreCase("manager")) {
            secondaryDuty.setOnMouseClicked(mouseEvent -> {
                switchToAttendanceReport();
            });
        }
        else if (staffMember.getRole().equalsIgnoreCase("chef")) {
                secondaryDuty.setOnMouseClicked(mouseEvent -> {
                    switchToSpecials();
                });
        }
    }


    public void getOrders(){
        if(staffMember.getRole().equals("deliveryDriver")) {
            try {
                if(data.getDeliveryInfo().isEmpty()) {
                    firstRole.setText("No orders");
                } else {
                    this.deliveryDetails =data.getDeliveryInfo();
                    this.userID= deliveryDetails.get(0);
                    this.userInfo= deliveryDetails.get(1);
                    firstRole.setText(userInfo);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void changeStatus() {

        if(staffMember.getRole().equals("deliveryDriver")) {
                try {
                    if(data.getDeliveryInfo().isEmpty()) {
                        secondRole.setText("No orders");
                    } else {
                        secondRole.setText("Order Delivered");
                        this.deliveryDetails = data.getDeliveryInfo();
                        this.userID = deliveryDetails.get(0);
                        this.userInfo = deliveryDetails.get(1);
                        data.changeDeliveryStatus(userID);
                    }
               // System.out.println("here ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
        thirdRole.setText("Staff Details");
        forthRole.setText("Attendance");
    }

    private void setChefDuties() {
        firstRole.setText("Make Order");
        secondRole.setText("Serve Customer");
        forthRole.setText("Daily Special");
        thirdRole.setText("Cooked Orders");
    }

    private void setDriverDuties() {
        firstRole.setText("Delivery Orders");
        secondRole.setText("Previous Orders");
        thirdRole.setText("Pending Orders");
        forthRole.setText("Vehicle Millage");
    }

    private void setWaiterDuties() {
        firstRole.setText("Take Order");
        secondRole.setText("Serve Order");
        thirdRole.setText("Print Receipt");
        forthRole.setText("Served orders");
    }


    @FXML
        private void switchToReport() {
        try {
            App.setRoot("report");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void switchToSpecials() {
        try {
            App.setRoot("specialMenu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void switchToAttendanceReport() {
        try {
            App.setRoot("attendance");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void switchToStaff() throws IOException {
        String attendanceSheet = "cafe94/src/main/resources/self/DataBase/staffAttendance.csv";
        updateClockOut(attendanceSheet,staffMember);
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
