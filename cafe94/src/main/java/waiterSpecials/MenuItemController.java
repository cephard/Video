package waiterSpecials;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import self.App;

import java.io.IOException;

public class MenuItemController extends MenuController {
    @FXML
    private Text nameText;
    @FXML
    private Text quantityText;
    @FXML
    private Text priceText;
    @FXML
    private Text caloriesText;
    @FXML
    private ImageView imageView;

    private MenuItem menuItem;

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("specialMenu");
    }

    // adding item to order
    @FXML
    private void addItemToOrder() {
        MenuController.order.addItem(menuItem);
    }

    @FXML
    public void initialize() {
        menuItem = MenuController.getItemFromMenu();

        if (menuItem != null) {
            nameText.setText(menuItem.getName());
            quantityText.setText("Quantity " + menuItem.getQuantity());
            caloriesText.setText(menuItem.getCalories() + " Kals");
            priceText.setText("£ " + menuItem.getPrice());

            // Load image if the path is available
            if (menuItem.getImagePath() != null && !menuItem.getImagePath().isEmpty()) {
                Image image = new Image("file:" + menuItem.getImagePath());
                imageView.setImage(image);
            }
        }
    }
}







