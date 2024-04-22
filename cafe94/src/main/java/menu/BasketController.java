package menu;

import basket.Basket;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class BasketController {

    MenuDataController itemDetails;
    Basket basket;
    public   String itemName;
    private double itemPrice;
    private double itemDiscount;
    private int quantity;
    private String type;


   // MenuDataController itemDetails;
    @FXML private Text nameText;
    @FXML private Text priceText;
    @FXML private Text quantityText;

    @FXML private Spinner quantitySpinner;

    private Stage stage;


    public void initialize(){
        //refreshItemText();
        refreshQuantitySpinner();
        menuButton.setOnAction(e -> {
            try {
                switchToMenu();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    @FXML private Button menuButton;

    //  MenuDataController itemDetails1;
    public void setItemDetails(MenuDataController itemDetails, Basket basket) {
        this.itemDetails=itemDetails;
        this.basket=basket;
        itemName=itemDetails.getName();
        itemPrice = itemDetails.getPrice();
        quantity = basket.findQantity(itemName);
        priceText.setText(String.valueOf(itemPrice));
        nameText.setText(itemName);
        quantityText.setText(quantity + "  in Basket");

    }


    public void loadDetails() throws  IOException{
           // App.setRoot("view");
    }

    public void setStage(Stage stage) {
        this.stage=stage;
    }
    private void switchToMenu() throws IOException {
            if (stage != null) {
                stage.close();
            }
    }
    private void refreshQuantitySpinner() {
//        if (currentOrderItem != null) {
//            SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, basket.getQuantity());
//            quantitySpinner.setValueFactory(valueFactory);
//        } else {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 1);
        quantitySpinner.setValueFactory(valueFactory);

        //}
    }
    @FXML
    private void addItemToBasket() throws IOException {
        quantity = (int) quantitySpinner.getValue();
        basket.addItem(itemName, itemPrice, quantity,itemDiscount,true);
       // basket.addItem(itemName, itemPrice);
        if (stage != null) {
            stage.close();
        }

    }
    @FXML
    private void removeItem() throws IOException {
        quantity = (int) quantitySpinner.getValue();
       basket.removeItem(itemName, itemPrice, quantity);
       // basket.addItem(itemName, itemPrice, quantity,itemDiscount);
        // basket.addItem(itemName, itemPrice);
        if (stage != null) {
            stage.close();
        }
    }


}
