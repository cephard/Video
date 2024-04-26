package staff;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
//import order.Order;
import self.App;

import java.io.IOException;
import java.util.Map;

public class StaffController extends StaffDataController {
    @FXML
    //protected static Order order = new Order(2334);
    private static StaffMember selectedStaffMember;
    Map<String, StaffMember> staffMembersMap;
    @FXML
    private Button backButton;
    @FXML
    private Button checkOutButton;
    @FXML
    private StackPane managerStackPane;
    @FXML
    private StackPane chefStackPane;
    @FXML
    private StackPane waiterStackPane;
    @FXML
    private StackPane deliveryDriverStackPane;
    {
        try {
            staffMembersMap = loadMenuFromCSV("cafe94/src/main/resources/self/DataBase/staffList.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to extract selected items from the menu in form of an order
     *
     * @Ceph
     */

    public static StaffMember getItemFromMenu() {
        return selectedStaffMember;
    }

    public void initialize() {
        managerStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMembersMap.get("manager"));
        });
        chefStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMembersMap.get("chef"));
        });
        waiterStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMembersMap.get("waiter"));
        });
        deliveryDriverStackPane.setOnMouseClicked(event -> {
            handleStackPaneClick(staffMembersMap.get("deliveryDriver"));
        });
    }

    /**
     *
     * @param staffMember
     */
    private void handleStackPaneClick(StaffMember staffMember) {
        selectedStaffMember = staffMember;
        if (staffMember.getRole().equals("manager")) {
            switchToManager();
        } else {
            switchToStaffMember();
        }
    }

    /**
     *
     */
    private void switchToStaffMember() {
        try {
            App.setRoot("staffMember");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void switchToManager() {
        try {
            App.setRoot("Manager");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

    @FXML
    private void switchToOrder() throws IOException {
        App.setRoot("order");
    }
}