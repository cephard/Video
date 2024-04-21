/*This class is used to store Name of the Items */

public class Item {
    
   private String name;
   private static final String NAME_INFO = "Item: %s, ";
   
   private Data priceQuantityDiscount;
   
   //To set name and passing values to data class
   public Item(String name, Data values) {
       this.name = name;
       priceQuantityDiscount = values;
   }

   /*getName function return Name of required item */
   public String getName() {
    return name;
   }

   /*getPrice function receive value from Data class and return Price of required item */
   public double getPrice() {
    return priceQuantityDiscount.getPrice();
   }

   /*getQuantity function receive value from Data class and return Quantity of required item */
   public int getQuantity() {
         return priceQuantityDiscount.getQuantity();
   }

   /*getDiscount function receive value from Data class and return Discount of required item */
   public double getDiscount() {
        return priceQuantityDiscount.getDiscount();
    }

    /*getNameAndPrice function receive Price value from Data class 
     and Name to it ,returns name and price in string */
   public String getNameAndPrice() {
        String text;
        text =  String.format(NAME_INFO, getName());
        text += String.format(priceQuantityDiscount.getPriceInfo(),priceQuantityDiscount.getPrice());
        return text;
    }

   /*received from Data class Total price of same item including discount on it */
   public double getTotalPriceOfItem() {
    double price;
    price = priceQuantityDiscount.getTotalPriceOfItem();
    return price;
    }

    /*Overriding toString function to get required text
     * here getting string from Data class and adding one more string 
    */
   @Override
    public String toString() {
        String text;  
        text = String.format(NAME_INFO, getName()) + this.priceQuantityDiscount.toString();
        return text;
    }

}
