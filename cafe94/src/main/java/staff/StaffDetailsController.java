package staff;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import self.App;

import java.io.IOException;

public class StaffDetailsController{

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
    private ImageView imageView;

    public void initialize() {
        Staff staffMember = StaffController.getEmployeeFromStaffList();
            if (staffMember.getImagePath() != null && !staffMember.getImagePath().isEmpty()) {
                Image image = new Image("file:" + staffMember.getImagePath());
                imageView.setImage(image);
            }

    }
    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("staffMember");
    }
}
