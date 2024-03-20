package self;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Menu {

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }
    //need to add some stuff
}
