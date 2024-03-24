package menu;

public class MenuDataController {
    //HashMap<String,Integer> itemsData = new HashMap<String,Integer>();


    public String getItemInfo(int n,String item){
        String itemInfo="Try " + n +" "+item;

        return itemInfo ;
    }
    public double getItemPrice(String item) {
        return 0.0;
    }
//    public HashMap<String,Integer> getItemsData(int n,String item) {
//        HashMap<String,Integer> itemsData = new HashMap<String,Integer>();
//
//
//        return itemsData;
//    }
}
