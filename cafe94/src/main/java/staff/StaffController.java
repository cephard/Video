package staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
//import report.Order;
import report.Report;
import self.App;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

public class StaffController extends StaffDataController {
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
    protected static Report report = new Report();


    {
        try {
            staffMemberList = loadStaffDetails("cafe94/src/main/resources/self/DataBase/staffList.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to extract selected employee from the staff list
     *
     */

    public static Staff getEmployeeFromStaffList() {
        return selectedStaffMember;
    }

    public void initialize() {
        chefStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("chef"));
        });
        waiterStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("waiter"));
        });
        deliveryDriverStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("deliveryDriver"));
        });
        managerStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMemberList.get("manager"));
        });
    }

    /**
     * Opens new Scene with staff member details
     * clocks in automatically to keep track of staff activity in the cafe
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

    public static Report getReportFromStaff() {
        return report;
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
