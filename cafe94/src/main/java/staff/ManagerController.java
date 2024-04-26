package staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import self.App;

import java.io.IOException;

public class ManagerController {
    @FXML
    private void switchToStaff() throws IOException {
        App.setRoot("staff");
    }

}
