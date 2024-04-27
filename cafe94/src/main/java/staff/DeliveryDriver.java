/**
 * This class contains details about the delivery driver where they will
 * be able to access an order and deliver it
 */
package staff;

import basket.Order;

import java.util.ArrayList;

public class DeliveryDriver extends Employee {
    private String vehicleType;
    private String vehicleRegistration;
    private ArrayList<Order> deliveredOrders;
    private int totalMillage;


    /**
     * Constructor to create a new delivery driver
     * @param id
     * @param firstName
     * @param lastName
     * @param role
     * @param shift
     * @param imagePath
     * @param vehicleType
     * @param vehicleRegistration
     */
    public DeliveryDriver(int id, String firstName, String lastName, String role,int shift,String imagePath,
                  String vehicleType, String vehicleRegistration) {
        super(id, firstName, lastName, role,shift,imagePath);
        this.vehicleType = vehicleType;
        this.vehicleRegistration = vehicleRegistration;
        this.deliveredOrders = new ArrayList<>();
    }

    /**
     * Delivers an order to a customer and adds the order into the list of successful deliveries
     * @param newOrder
     * @param millage
     * @return
     */
    public boolean deliverOrder(Order newOrder, int millage) {
        deliveredOrders.add(newOrder);
        totalMillage += millage;
        return true; // Assuming the delivery is always successful
    }
}
