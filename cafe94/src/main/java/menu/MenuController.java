package menu;

import basket.Basket;
import basket.BasketLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import login.LoginController;
import self.App;
import self.Result;

import java.io.IOException;

public class MenuController {




    Result cTypeData = Result.getInstance();
    LoginController data = LoginController.getInstance();
    MenuDataController itemData = new MenuDataController();
    Basket basket = new Basket(data.getUserID(), 0);
    BasketLoader basketLoader = new BasketLoader();

   // String customerType = cTypeData.getCustomerType();
    @FXML private Text item1;
    @FXML private Text item2;
    @FXML private Text item3;
    @FXML private Text item4;
    @FXML private Text item5;
    @FXML private Text item6;
    @FXML private Text item7;
    @FXML private Text item8;
    @FXML private Text item9;
    @FXML private Text item10;
    @FXML private Text item11;
    @FXML private Text item12;
    @FXML private Text userName;

    @FXML
    private StackPane stackPane2;

    @FXML
    private StackPane stackPane3;
    @FXML
    private StackPane stackPane4;
    @FXML
    private StackPane stackPane5;
    @FXML
    private StackPane stackPane6;
    @FXML
    private StackPane stackPane7;
    @FXML
    private StackPane stackPane8;
    @FXML
    private StackPane stackPane9;
    @FXML
    private StackPane stackPane10;
    @FXML
    private StackPane stackPane11;
    @FXML
    private StackPane stackPane12;
    @FXML private TextArea showBasketItems;
    @FXML private Text showBasketItems2;
    @FXML private Text customerType;
    @FXML private StackPane stackPane1;
    public void initialize(){
        userName.setText(data.getUserName());
        //System.out.println(data.getUserID());
        if(basketLoader.basketStatus(data.getUserID()).equals("Yes")){
            basketLoader.loadBasket(data.getUserID(),basket);
        } else {
            basketLoader.changeBasketStatus(data.getUserID(),"Yes");
        }
        customerType.setText(cTypeData.getCustomerType());
    }

    //@FXML private Text item12;
    public String[] items = new String[5];
    private BorderPane borderpane;
    String item;
    int rNum;


    public void setItems(int limit,int rNum,String item) {
        item1.setText(null);
        item2.setText(null);
        item3.setText(null);
        item4.setText(null);
        item5.setText(null);
        this.rNum=rNum;
        if(limit>=1) {

            items[0] = itemData.getItemInfo(rNum,1, item);
            item1.setText(items[0]);
        }
        if(limit>=2) {

            items[1] = itemData.getItemInfo(rNum,2, item);
            item2.setText(items[1]);
        }
        if(limit>=3) {

            items[2] = itemData.getItemInfo(rNum,3, item);
            item3.setText(items[2]);
        }
        if(limit>=4) {

            items[3] = itemData.getItemInfo(rNum,4, item);
            item4.setText(items[3]);
        }
        if(limit>=5) {

            items[4] = itemData.getItemInfo(rNum,5, item);
            item5.setText(items[4]);
        }
        item6.setText(null);
    }

    @FXML
    public void switchToWelcome() throws IOException {
        App.setRoot("passResult");
    }

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }
    @FXML
    private void openHotDrink() throws IOException {
        
        String item="HotDrinks";
        setItems(5,1,item);

    }
    @FXML
    private void openColdDrink() throws IOException {
         item="ColdDrinks";
        setItems(5,3,item);
    }
    @FXML
    private void openDonuts() throws IOException {
         item="Donuts";
        setItems(5,5,item);
    }
    @FXML
    private void openWrap() throws IOException {
         item="Wrap";
        setItems(4,7,item);
    }
    @FXML
    private void openSandwiches() throws IOException {
         item="Sandwiches";
        setItems(2,9,item);
    }
    @FXML
    private void openBurgers() throws IOException {
         item="Burgers";
        setItems(3,11,item);
    }
    @FXML
    private void openChickenTenders() throws IOException {
         item="ChickenTenders";
        setItems(3,13,item);
    }
    @FXML
    private void openSides() throws IOException {
         item="Sides";
        setItems(2,15,item);
    }
    @FXML
    private void openVegg() throws IOException {
         item="Vegg";
        setItems(2,17,item);
    }
    @FXML
    private void openSpecialItems() throws IOException {
         item="SpecialItems";
        setItems(1,19,item);
    }

    private void setView(Text itemText,int cNum) throws IOException {
        if(itemText.getText().isEmpty()) {
            App.setRoot("menu2");
        } else {
            itemData.setItemsData(rNum,cNum,this.item);
           // viewItemDetails.setItemDetails(itemData);
           editItem(itemData);
          // App.setRoot("sub");
        }
    }
    @FXML
    private void viewItem1() throws IOException {
        setView(item1,1);
    }

    @FXML
    private void viewItem2() throws IOException {
        setView(item2,2);
    }
    @FXML
    private void viewItem3() throws IOException {
        setView(item3,3);
    }
    @FXML
    private void viewItem4() throws IOException {
        setView(item4,4);
    }
    @FXML
    private void viewItem5() throws IOException {
        setView(item5,5);
    }

    private void viewItem6() throws IOException {
    }private void viewItem7() throws IOException {
    } private void viewItem8() throws IOException {
    } private void viewItem9() throws IOException {
    } private void viewItem10() throws IOException {
    } private void viewItem11() throws IOException {
    }private void viewItem12() throws IOException {
    }


    public String getBasket() {
        return basket.toString();
    }
    @FXML
    private void switchToBasket() throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("basketView.fxml"));
        Parent root = loader.load();
        BasketView controller = loader.getController();
        controller.itemsInBasket(basket);


        Stage basketViewStage = new Stage();
        controller.setStage(basketViewStage);
        basketViewStage.setTitle("Basket View");
        basketViewStage.setScene(new Scene(root, 450, 450));
        basketViewStage.initModality(Modality.APPLICATION_MODAL);
        basketViewStage.showAndWait();
    }
    @FXML
    private void placeOrder() {
        if(basket.basketStatus()) {
            Stage newStage = new Stage();
            newStage.setTitle("Basket is Empty");
            StackPane newRoot = new StackPane();
            newRoot.getChildren().add(new Text("Add items in basket to place report "));
            newStage.setScene(new Scene(newRoot, 300, 200));
            newStage.show();
        }else {
            if(cTypeData.getCustomerType().equals("Delivery")) {
                basketLoader.setDeliveryInfo(basket.getUserId(), data.getUserName(), data.getUserAddress(),basket.toString());
            }
            basketLoader.storeOrder(basket.getUserId(),basket.toString());
            basketLoader.changeBasketStatus(basket.getUserId(),"No");
            basketLoader.deleteTempBasket(basket.getUserId());
            basket.emptyBasket();

            Stage newStage = new Stage();
            newStage.setTitle("Order Confirmation");
            StackPane newRoot = new StackPane();
            newRoot.getChildren().add(new Text("Your Order Accepted "));
            newStage.setScene(new Scene(newRoot, 300, 200));
            newStage.show();
        }

    }
    private void editItem(MenuDataController itemData) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("sub.fxml"));
        Parent root = loader.load();
        BasketController controller = loader.getController();
        controller.setItemDetails(itemData,basket);


        Stage orderTypeStage = new Stage();
        controller.setStage(orderTypeStage);
        orderTypeStage.setTitle("Edit Item Detail");
        orderTypeStage.setScene(new Scene(root, 450, 450));
        orderTypeStage.initModality(Modality.APPLICATION_MODAL);
        orderTypeStage.showAndWait();
      //  refreshOrderItemList();
    }

    public void openOrderHistory() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("orderHistory.fxml"));
        Parent root = loader.load();
        OrderHistory controller = loader.getController();
        controller.itemsInBasket(basket.getUserId());


        Stage orderViewStage = new Stage();
        controller.setStage(orderViewStage);
        orderViewStage.setTitle("Order History");
        orderViewStage.setScene(new Scene(root, 500, 500));
        orderViewStage.initModality(Modality.APPLICATION_MODAL);
        orderViewStage.showAndWait();
    }

    public void openEvent() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("event.fxml"));
        Parent root = loader.load();
        Event controller = loader.getController();
        controller.setEvent(basket.getUserId());


        Stage eventViewStage = new Stage();
        controller.setStage(eventViewStage);
        eventViewStage.setTitle("Event Registration");
        eventViewStage.setScene(new Scene(root, 500, 500));
        eventViewStage.initModality(Modality.APPLICATION_MODAL);
        eventViewStage.showAndWait();
    }
}
