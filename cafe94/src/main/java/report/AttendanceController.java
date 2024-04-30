package report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import self.App;
import staff.Staff;
import staff.StaffDataController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Controller class for managing reports in the system.
 */
public class AttendanceController {

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
     * Initializes the controller, populating the report ListView with staff attendance records.
     */
    @FXML
    public void initialize() {
        ObservableList<String> attendanceRecords = FXCollections.observableArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("cafe94/src/main/resources/self/DataBase/staffAttendance.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                attendanceRecords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle IO Exception
        }
        reportListView.setItems(attendanceRecords);
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
