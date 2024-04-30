package menu;

import basket.Basket;
import basket.BasketLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import self.App;

import java.io.IOException;
import java.util.ArrayList;

public class OrderHistory {
    BasketLoader data = new BasketLoader();
    ArrayList<String> orders = new ArrayList<String>();


    @FXML private HBox container ;

    public void initialize() {
        refreshCardDisplay();
    }

    public void itemsInBasket(String userID) {
//        if (data.basketStatus()) {
//            basketView.setText("Basket is Empty \n Add items ");
//        } else {
//            basketView.setText(basket.toString());
//        }
        if(data.getOrderHistory(userID).isEmpty()) {
            this.orders.add("There is no report History");
        } else {
            this.orders = data.getOrderHistory(userID);
        }

        //System.out.println("here   ");
        //this.orders.add("basket dadadadadawd");

       // this.orders.add("basket22222222222 dadadadadawd");
        initialize();
    }

        private void addCard() throws IOException {

            try {
                for (int i=0;i<this.orders.size();i++) {

                    FXMLLoader loader = new FXMLLoader(App.class.getResource("orderCard.fxml"));
                        StackPane stackPane = loader.load();
                        OrderCard controller = loader.getController();
                        controller.setOrder(orders.get(i));
                        controller.initialize();
                        container.getChildren().add(stackPane);
                    }
                }
             catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void refreshCardDisplay() {
        container.getChildren().clear(); // Clear existing cards
        try {
            addCard(); // Add cards again
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setStage(Stage stage) {
        this.orderViewStage=stage;
    }

    @FXML Stage orderViewStage;

    @FXML
    public void switchToMenu() throws IOException {
        if (orderViewStage != null) {
            orderViewStage.close();
        }
    }
}
