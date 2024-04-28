package menu;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OrderCard {


    @FXML private Text orderData;
    String order="Ntn";

    public void setOrder(String order) {
        this.order = order;
    }

    public void initialize() {
        orderData.setText(this.order);
    }
}
