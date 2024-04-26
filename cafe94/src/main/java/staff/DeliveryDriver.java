package staff;

import basket.Order;

import java.util.ArrayList;

public class DeliveryDriver extends Employee {
    private String vehicleType;
    private String vehicleRegistration;
    private ArrayList<Order> deliveredOrders;
    private int totalMilage;

    public DeliveryDriver(int id, String firstName, String lastName, String role,
                  String vehicleType, String vehicleRegistration) {
        super(id, firstName, lastName, role);
        this.vehicleType = vehicleType;
        this.vehicleRegistration = vehicleRegistration;
        this.deliveredOrders = new ArrayList<>();
    }

    public boolean deliverOrder(Order newOrder, int milage) {
        deliveredOrders.add(newOrder);
        totalMilage += milage;
        return true; // Assuming the delivery is always successful
    }
}
