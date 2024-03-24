package menu;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import self.App;

import java.io.IOException;
import java.util.HashMap;

public class MenuController {
    MenuDataController itemData = new MenuDataController();
    //String basket="";
    HashMap<String,Integer> basket = new HashMap<String, Integer>();
    @FXML private Text item1;
    @FXML private Text item2;
    @FXML private Text item3;
    @FXML private Text item4;
    @FXML private Text item5;
    @FXML private Text item6;

    @FXML private TextArea showBasketItems;
    @FXML private Text showBasketItems2;
   public String[] items = new String[5];
    public void setItems(String item) {
        items[0] = itemData.getItemInfo(1,item);
        item1.setText(items[0]);

        items[1]=itemData.getItemInfo(2,item);
        item2.setText(items[1]);

        items[2]=itemData.getItemInfo(3,item);
        item3.setText(items[2]);

        items[3]=itemData.getItemInfo(4,item);
        item4.setText(items[3]);

        items[4]=itemData.getItemInfo(5,item);
        item5.setText(items[4]);
    }
    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }
    @FXML
    private void openHotDrink() throws IOException {
        String item="HotDrinks\n";
        setItems(item);
//        item1.setText(itemData.getItemInfo(1,item));
//        item2.setText(itemData.getItemInfo(2,item));
//        item3.setText(itemData.getItemInfo(3,item));
//        item4.setText(itemData.getItemInfo(4,item));
//        item5.setText(itemData.getItemInfo(5,item));
        //App.setRoot("");
    }
    @FXML
    private void openColdDrink() throws IOException {
        String item="ColdDrinks\n";
        setItems(item);
    }
    @FXML
    private void openDonuts() throws IOException {
        String item="Donuts";
        setItems(item);
    }
    @FXML
    private void openWrap() throws IOException {
        String item="Wrap";
        setItems(item);
    }
    @FXML
    private void openSandwiches() throws IOException {
        String item="Sandwiches";
        setItems(item);
    }
    @FXML
    private void openBurgers() throws IOException {
        String item="Burgers";
        setItems(item);
    }
    @FXML
    private void openChickenTenders() throws IOException {
        String item="ChickenTenders";
        setItems(item);
    }
    @FXML
    private void openSides() throws IOException {
        String item="Sides";
        setItems(item);
    }
    @FXML
    private void openVegg() throws IOException {
        String item="Vegg";
        setItems(item);
    }
    @FXML
    private void openSpecialItems() throws IOException {
        String item="SpecialItems";
        setItems(item);
    }
    @FXML
    private void addItem1() throws IOException {
        addToBasket(items[0]);
        //basket+=items[0] + "\n";
    }
    @FXML
    private void addItem2() throws IOException {
        addToBasket(items[1]);
        //basket+=items[1] + "\n";
    }
    @FXML
    private void addItem3() throws IOException {
        addToBasket(items[2]);
        //basket+=items[2] + "\n";
    }
    @FXML
    private void addItem4() throws IOException {
        addToBasket(items[3]);
        //basket+=items[3] + "\n";
    }
    @FXML
    private void addItem5() throws IOException {
        addToBasket(items[4]);
        //basket+=items[4] + "\n";
    }

    @FXML
    private void showOrderList() throws IOException {

        //showBasketItems.setText(basket);
        showBasketItems2.setText(getBasket());

    }
//    @FXML
//    private void viewFresh() throws IOException{
//        App.setRoot("menu");
//    }
    public void addToBasket(String item){
        if(basket.isEmpty()) {
            basket.put(item,1);
        } else if(basket.containsKey(item)) {
                basket.replace(item,1+basket.get(item));
            } else{
                basket.put(item,1);
            }
    }

    public String getBasket() {


        return basket.toString();
    }
}
