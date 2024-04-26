package staff;

import basket.Order;

import java.util.ArrayList;

public class Waiter extends Employee {
    private ArrayList<Order> approvedOrders;

    public Waiter(int id, String firstName, String lastName, String role) {
        super(id, firstName, lastName, role);
        this.approvedOrders = new ArrayList<>();
    }

    public void eatInOrder(Order newOrder) {
        approvedOrders.add(newOrder);
    }

    public void approveDelivery(Order newOrder) {
        approvedOrders.add(newOrder);
    }
}
