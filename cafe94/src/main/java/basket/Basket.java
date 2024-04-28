/**
 *
 */
package basket;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items = new ArrayList<Item>();
    public BasketDataController tempBasket = new BasketDataController();
    private String basketID;             //to store Basket ID
    private double voucher = 0.00;   //total voucher applied to Basket
    private Item itemsNPQD;         //items name price quantity discount

    private static final String BASKET_INFO = "Basket %s has the following items:\n";
    private static final String VOUCHER_INFO = "Voucher applied: %.0f%%\n";
    private static final String TOTAL_INFO = "Total cost: %.2f pounds\n";
    private static final String EMPTY_INFO = "null";

    private static final int HUNDRED = 100; 
    
   
    public Basket(String basketID) {
       /*Constructor to assign  Price */
        this.basketID = basketID;
    }

    public String getUserId() {
        return basketID;
    }

    /*Constructor to assign  Price and voucher */

    /**
     *
     * @param basketID
     * @param voucher
     */
    public Basket(String basketID, double voucher) {
      this.basketID = basketID;
      this.voucher = voucher;
    }

   
    public void addItem(String name, double price) {
       /*addItem function works when name and price arguments are passed.
        creating Item class object and adding to array list */
      if (price>0.00) {
        itemsNPQD = new Item(name, new Data(price));
        items.add(itemsNPQD);
      }
         
    }

    /*addItem function works when name, price, qunatity and discount arguments are passed.
       Here it valids given (Price Qunatity and Discount) and
       creats Item class object and adding to array list */

    public void addItem(String name, double price, int quantity, double discount, boolean tempLoader) {
        if(tempLoader) {
            tempBasket.setItemsData(basketID,name,price,quantity);
        }

        if (findAnItem(name, price).equals(EMPTY_INFO)) {
          itemsNPQD = new Item(name, new Data(price, quantity, discount));
          items.add(itemsNPQD);
           } else {
              for (int i=0; i<items.size(); i++) {
                 if (items.get(i).getName().equalsIgnoreCase(name)) {

                  if (discount>items.get(i).getDiscount() && (discount>=0.00 && discount < 1)) {
                      itemsNPQD = new Item(name, new Data(price, 
                                 quantity + items.get(i).getQuantity(), discount));
                     items.set(i, itemsNPQD); //Updating new values 

                   } else {
                            itemsNPQD = new Item(name, new Data(price, quantity 
                                        + items.get(i).getQuantity(), items.get(i).getDiscount()));
                            items.set(i, itemsNPQD);   //Updating new values
                              
                        }
                 break;//to stop the loop after finding item
               } 
             }
           }

      }
    public void removeItem(String name, double price, int quantity ){
        Item item;
        for (int i=0; i<items.size(); i++) {
            if (name.equalsIgnoreCase(items.get(i).getName()) && price==items.get(i).getPrice()) {
                //text = items.get(i).getNameAndPrice();
                if(items.get(i).getQuantity()>quantity) {
                    item = new Item(name, new Data(price,items.get(i).getQuantity()-quantity,0.0));
                    items.set(i, item);
                }
                else if(items.get(i).getQuantity()<=quantity) {
                    System.out.println("here");
                    items.remove(i);
                }

            }
        }
    }
    public int findQantity(String name) {
        if(items.isEmpty()) {
            return 0;
        }
        for (int i=0; i<items.size(); i++) {
            if (name.equalsIgnoreCase(items.get(i).getName())) {
                return  items.get(i).getQuantity();
            }
        }
        return 0;
    }
    public double totalBasket() {
      /*returning total price of all items including discount
      price is received frm Data class */
      
     double sum=0.00;
       for (int i=0; i<items.size(); i++) {
          sum += items.get(i).getTotalPriceOfItem();
       }
       if (voucher>0.0 && voucher <1.0) { 
             sum = (1-voucher)*sum;
       }
       return sum;
   }

  
   public String findAnItem(String name, double price) {
     /*Searching specified Item by  Name and price */

    String text=EMPTY_INFO;

    for (int i=0; i<items.size(); i++) {
        if (name.equalsIgnoreCase(items.get(i).getName()) && price==items.get(i).getPrice()) {
           text = items.get(i).getNameAndPrice();
           return  text;
       }
    }
    return text;
  }

  
   public String cheapestItem() {
    /*Comparing price of all stored items and 
    returns cheapest item's name and price in string format
   */

    String text = EMPTY_INFO;
    double cheap = 0.00;
    int cheapIndex = 0;

    if (!(items.isEmpty())) {
       cheap = items.get(0).getTotalPriceOfItem();
      for (int i=0; i<items.size(); i++) {
        if (cheap>items.get(i).getTotalPriceOfItem()) {
          cheap = items.get(i).getTotalPriceOfItem();
           cheapIndex = i;
        }
      }
    text = items.get(cheapIndex).getNameAndPrice();
   
      }
    return text;
   }

    public boolean basketStatus() {
        if(items.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

   public String mostExpensiveItem() {
     /*Comparing price of all stored items and 
     returns expenseive item's name and price in string format
   */

    String text = EMPTY_INFO;
    int expenseIndex = 0;
    double expense = 0.00;
    if (!(items.isEmpty())) {
      expense = items.get(0).getTotalPriceOfItem();
       for (int i=0; i<items.size(); i++) {
          if (expense<items.get(i).getTotalPriceOfItem()) {
            expense =items.get(i).getTotalPriceOfItem();
              expenseIndex = i;
            }
        }
      text = items.get(expenseIndex).getNameAndPrice();
      }
      return text;
    }

    public void emptyBasket() {
        items.clear();
    }
    @Override
    public String toString() {
      String text = "";
      text = String.format(BASKET_INFO, basketID);
      if (!(items.isEmpty())) {
        for (int i=0; i<items.size(); i++) {
          text += items.get(i).toString();
        }
      }
      if (voucher>0.0 && voucher <1.0) {
        text += String.format(VOUCHER_INFO, voucher*HUNDRED);
     }
      text += String.format(TOTAL_INFO, totalBasket());
      return text;
    }
}
