package report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import self.App;
import staff.Staff;
import staff.StaffDataController;

import java.io.IOException;
import java.util.Map;

/**
 * Controller class for managing reports in the system.
 */
public class ReportController {

    /**
     * Reference to the current report retrieved from the Staff.
     */
    Report report = new Report();

    /**
     * ListView component to display the report staff members.
     */
    @FXML
    private ListView<String> reportListView = new ListView<>();

    /**
     * Switches the scene to the staff view.
     *
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    private void switchToStaff() throws IOException {
        App.setRoot("staff");
    }

    /**
     * Initializes the controller, populating the report ListView with staff details.
     */
    @FXML
    public void initialize() {
        ObservableList<String> staffReport = FXCollections.observableArrayList();
        try {
            Map<String, Staff> staffMap = StaffDataController.loadStaffDetails("cafe94/src/main/resources/self/DataBase/staffList.csv");
            for (Staff staff : staffMap.values()){
                String staffInfo = String.format("First Name:  %s, Last Name:  %s, Role:  %s, Shift:  %d Hours",
                        staff.getFirstName(), staff.getLastName(), staff.getRole(), staff.getShift());
                staffReport.add(staffInfo);
            }
            reportListView.setItems(staffReport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns to the start view.
     *
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    private void backToStaff() throws IOException {
        App.setRoot("staffMember");
    }
}
