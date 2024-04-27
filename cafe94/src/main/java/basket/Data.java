/*This class is used to store Price, Quantity and Discount of the item */
package basket;

public class Data {

    private double price = 0.00;
    private int quantity = 1;
    private double discount = 0.0;
    
    private static final String PRICE_INFO = "price: %.2f pounds";
    private static final String QUNATITY_INFO = ", quantity: %d";
    private static final String DISCOUNT_INFO =", discount: %.0f%%\n";
    private static final int HUNDRED = 100;

    //storing only price
    public Data(double price) {
        this.price = price;
    }

    //storing price quantity discount
    public Data(double price, int quantity, double discount) {
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    /*getPrice function return Price of certain item */
    public double getPrice() {
        return price;
    }

    //price info in string format
    public String getPriceInfo() {
        return String.format(PRICE_INFO, getPrice());
    }


    /*getQuantity function return Quantity of certain item */
    public int getQuantity() {
        return quantity;
    }

    /*getDiscount function return Discount of certain item */
    public double getDiscount() {
        return discount;
    }


    // Total price of same item including discount on it 
    public double getTotalPriceOfItem() {
       
        double price = 0.00;
        price = (this.price* quantity * (1-discount));
        
        return price;
    }
    

    @Override
    public  String toString() {
        String text = "";
        if (discount>0.0) {
            text = String.format(PRICE_INFO, getPrice());
            text +=String.format(QUNATITY_INFO, getQuantity());
            text+=String.format(DISCOUNT_INFO, (getDiscount()*HUNDRED));
     
        } else if (quantity>1) {
                text = String.format(PRICE_INFO, getPrice());
                text +=String.format(QUNATITY_INFO, getQuantity());
                text += "\n";

        } else {
              text = String.format(PRICE_INFO, getPrice());
              text += "\n";
        }

        return text;
    }
}
