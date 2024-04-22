package menu;

import basket.Basket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BasketView {


    @FXML private Text basketView;
    @FXML private Stage basketViewStage;
    @FXML private Button returnToMenu;
    @FXML private Button placeOrder;

    public void initialize(){
//        returnToMenu.setOnAction(e -> {
//            try {
//                switchToMenu();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
        placeOrder.setOnAction(e -> {
            try {
                switchToMenu1();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void setStage(Stage stage) {
        this.basketViewStage=stage;
    }
    public void itemsInBasket(Basket basket) {
        basketView.setText(basket.toString());
    }
    @FXML
    public void switchToMenu() throws IOException {
        if (basketViewStage != null) {
            basketViewStage.close();
        }
    }
    public void switchToMenu1() throws IOException {
        if (basketViewStage != null) {
            basketViewStage.close();
        }
    }
}
