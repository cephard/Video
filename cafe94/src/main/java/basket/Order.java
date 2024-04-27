package basket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an order containing a list of menu items.
 */
public class Order {
    private final List<Item> order;
    private final String orderId;
    private final Date orderDate;
    private final String orderType;


    /**
     * Constructs an Order object with a specified order ID and the current date.
     *
     * @param orderId The ID of the order.
     */
    public Order(String orderId, String type) {
        this.order = new ArrayList<>();
        this.orderId = orderId;
        this.orderDate = new Date();
        this.orderType = type;
    }
    /**
     * Removes a menu item from the order.
     *
     * @param item The menu item to remove.
     */
    public void removeItem(Item item) {
        if (item != null) {
            if (order.contains(item)) {
                order.remove(item);
            } else {
                System.out.println("Item is not in the order.");
            }
        } else {
            System.out.println("Cannot remove null item from the order.");
        }
    }

    /**
     * Calculates the total price of the items in the order.
     *
     * @return The total price of the order.
     */
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : order) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * Retrieves all items in the order.
     *
     * @return A list of all items in the order.
     */
    public ArrayList<Item> getOrder() {
        return new ArrayList<>(order);
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The order ID.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Checks if the order is empty.
     *
     * @return True if the order is empty, false otherwise.
     */
    public boolean isEmpty() {
        return order.isEmpty();
    }

    /**
     * Formats the given date object to a string in "yyyy-MM-dd" format.
     *
     * @param date The date object to format.
     * @return The formatted date string.
     */
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}

