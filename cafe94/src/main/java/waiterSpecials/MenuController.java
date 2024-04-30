package waiterSpecials;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import waiterOrder.Order;
import self.App;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuController extends Menu {
    @FXML
    protected static Order order = new Order(2334);
    private static MenuItem selectedMenuItem;
    public String[] items = new String[5];
    MenuDataController itemData = new MenuDataController();
    HashMap<String, Integer> basket = new HashMap<>();
    Map<String, MenuItem> menuItemsMap;
    @FXML
    private Button backButton;
    @FXML
    private Button checkOutButton;
    @FXML
    private Text item1;
    @FXML
    private Text item2;
    @FXML
    private Text item3;
    @FXML
    private Text item4;
    @FXML
    private Text item5;
    @FXML
    private Text item6;
    @FXML
    private TextArea showBasketItems;
    @FXML
    private Text showBasketItems2;
    @FXML
    private StackPane stackPane1;
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

    {
        try {
            menuItemsMap = loadMenuFromCSV("cafe94/src/main/resources/self/DataBase/menu.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to extract selected items from the menu in form of an order
     *
     * @Ceph
     */
    public static Order getOrderFromMenu() {
        return order;
    }

    public static MenuItem getItemFromMenu() {
        return selectedMenuItem;
    }

    public void initialize() {
        stackPane1.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("croissant"));
        });
        stackPane2.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("avocadoToast"));
        });
        stackPane3.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("capreseSalad"));
        });
        stackPane4.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("grilledSandwich"));
        });
        stackPane5.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("blueBerryMuffin"));
        });
        stackPane6.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("quionaSalad"));
        });
        stackPane7.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("veggieWrap"));
        });
        stackPane8.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("brothBowl"));
        });
        stackPane9.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("chaiLatte"));
        });
        stackPane10.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("creamBagel"));
        });
        stackPane11.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("fruitSmoothie"));
        });
        stackPane12.setOnMouseClicked(event -> {
            handleStackPaneClick(menuItemsMap.get("clubSandwich"));
        });
    }

    /**
     *
     * @param menuItem
     */
    private void handleStackPaneClick(MenuItem menuItem) {
        selectedMenuItem = menuItem;
        switchToMenuItem();
    }

    /**
     *
     */
    private void switchToMenuItem() {
        try {
            App.setRoot("MenuItem");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("staffMember");
    }

    @FXML
    private void switchToOrder() throws IOException {
        App.setRoot("Order");
    }
}