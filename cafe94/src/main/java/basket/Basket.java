import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items = new ArrayList<Item>();
    
    private int basketID;             //to store Basket ID
    private double voucher = 0.00;   //total voucher applied to Basket
    private Item itemsNPQD;         //items name price quantity discount

    private static final String BASKET_INFO = "Basket %d has the following items:\n";
    private static final String VOUCHER_INFO = "Voucher applied: %.0f%%\n";
    private static final String TOTAL_INFO = "Total cost: %.2f pounds\n";
    private static final String EMPTY_INFO = "null";

    private static final int HUNDRED = 100; 
    
   
    public Basket(int basketID) {
       /*Constructor to assign  Price */
        this.basketID = basketID;
    }

   
    public Basket(int basketID, double voucher) {
       /*Constructor to assign  Price and voucher */
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

   
    public void addItem(String name, double price, int quantity, double discount) {
      /*addItem function works when name, price, qunatity and discount arguments are passed. 
      Here it valids given (Price Qunatity and Discount) and 
      creats Item class object and adding to array list */
     
      if (price>0.00 && quantity>0) {
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
      }
    
    
    public double totalBasket() {
      /*returning tooal price of all items including discount
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
