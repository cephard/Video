/**
 *
 */

package staff;

import javafx.scene.image.Image;

public class StaffMember{
    private String name;
    private String role;
    private int shift;
    private final String itemImagePath;
    private int quantity;
    private Image image;


    public StaffMember(String name, String role, int shift, String itemImagePath) {
        this.name = name;
        this.role = role;
        this.shift = shift;
        this.itemImagePath = itemImagePath;
    }

    public void setItemImage(String itemImagePath) {

    }

    public String getImagePath() {
        return itemImagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setType(String type) {
        this.role = role;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity() {
        quantity++;
    }

    public void setQuantity(int quantity) {
    }



    //this tostring is for testing to see if the class actually works
    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", role='" + role+ '\'' +
                ", shift=" + shift +
                '}';
    }
}


