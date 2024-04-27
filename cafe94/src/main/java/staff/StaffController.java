package staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
//import order.Order;
import self.App;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

public class StaffController extends StaffDataController {
    @FXML
    //protected static Order order = new Order(2334);
    private static Staff selectedStaffMember;
    Map<String, Staff> staffMemberList;
    @FXML
    private Button backButton;
    @FXML
    private Button checkOutButton;
    @FXML
    private StackPane managerStackPane;
    @FXML
    private StackPane chefStackPane;
    @FXML
    private StackPane waiterStackPane;
    @FXML
    private StackPane deliveryDriverStackPane;

    LocalTime currentTime = LocalTime.now();


    {
        try {
            staffMemberList = loadStaffDetails("cafe94/src/main/resources/self/DataBase/staffList.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to extract selected items from the menu in form of an order
     *
     * @Ceph
     */

    public static Staff getEmployeeFromStaffList() {
        return selectedStaffMember;
    }

    public void initialize() {
        managerStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("manager"));
        });
        chefStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("chef"));
        });
        waiterStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("waiter"));
        });
        deliveryDriverStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("deliveryDriver"));
        });
    }

    /**
     * Opens new Scene with staff member details
     * @param staffMember
     */
    private void handleStackPaneClick(Staff staffMember) {
        String attendanceSheet = "cafe94/src/main/resources/self/DataBase/staffAttendance.csv";
        selectedStaffMember = staffMember;
        selectedStaffMember.clockIn(currentTime);
        try {
            updateClockIn(attendanceSheet,selectedStaffMember);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switchToStaffMember();
    }

    /**
     *
     */
    private void switchToStaffMember() {
        try {
            App.setRoot("staffMember");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

    /**
     * method to access the selected staff member
     * @return
     */
    public static Staff getSelectedStaffMember() {
        return selectedStaffMember;
    }
}
