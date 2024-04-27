package staff;

import javafx.fxml.FXML;
import self.App;

import java.io.IOException;

public class ManagerController {
    Staff manager = StaffController.getSelectedStaffMember();
    @FXML
    private void switchToStaff() throws IOException {
        App.setRoot("staff");
    }



}
