package transaction;


import waiterSpecials.MenuController;
import waiterOrder.Order;

public class Transaction {
    Order order = MenuController.getOrderFromMenu();
    public double payAmount(double amount) {
        if (amount < order.getTotalPrice()) {
            System.out.println("Insuffcient funds");
        }
        return amount;
    }
}
