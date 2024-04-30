package waiterSpecials;

import javafx.scene.image.Image;

public class MenuItem {
    private String name;
    private String type;
    private double price;
    private int calories;
    private boolean vegan;
    private final String itemImagePath;
    private int quantity;
    private Image image;

    /**
     *
     * @param name
     * @param type
     * @param price
     * @param calories
     * @param vegan
     * @param quantity
     * @param itemImagePath
     */
    public MenuItem(String name, String type, double price, int calories, boolean vegan, int quantity, String itemImagePath) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.calories = calories;
        this.vegan = vegan;
        this.quantity = quantity;
        this.itemImagePath = itemImagePath;
    }

    /**
     *
     * @param name
     * @param type
     * @param vegan
     * @param itemImagePath
     */
    public MenuItem(String name, String type, boolean vegan, String itemImagePath) {
        this.name = name;
        this.type = type;
        this.vegan = vegan;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if (calories < 5 || calories > 100){
            this.calories = -1;
        }else {
            this.calories = calories;
        }
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
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
                ", type='" + type + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                ", vegan=" + vegan +
                '}';
    }
}


