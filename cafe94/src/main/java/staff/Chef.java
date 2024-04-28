package staff;

import basket.Order;

import java.util.List;

public class Chef extends Employee{
    private List<Order> pendingOrders;
    public Chef(int id, String firstName, String lastName, String role,int shift,String imagePath, List<Order> orders) {
        super(id, firstName, lastName, role,shift,imagePath);
        this.pendingOrders = orders;
    }

    public Chef(int id, String firstName, String lastName, String role, int shift, String imagePath) {
        super(id, firstName, lastName, role,shift,imagePath);
    }

    public void dailySpecial() {

    }

    //public void markOrderState(Order currentOrder) {
      //  currentOrder.setCooked(true);
    //}
}
