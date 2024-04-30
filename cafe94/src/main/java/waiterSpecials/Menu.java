package waiterSpecials;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {

    //saving menu items to csv file

    /**
     *
     * @param menuMap
     * @param filePath
     * @throws IOException
     */
    public static void saveMenuToDataBase(Map<String, MenuItem> menuMap, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name,Type,Price,Calories,Vegan,Quantity,ImagePath");
            writer.newLine();
            for (MenuItem menuItem : menuMap.values()) {
                writer.write(String.format("%s,%s,%.2f,%d,%b,%d,%s",
                        menuItem.getName(), menuItem.getType(), menuItem.getPrice(),
                        menuItem.getCalories(), menuItem.isVegan(), menuItem.getQuantity(),
                        menuItem.getImagePath()));
                writer.newLine();
            }
        }
    }

    //loading menu items from the csv file

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Map<String, MenuItem> loadMenuFromCSV(String filePath) throws IOException {
        Map<String, MenuItem> menuMap = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String type = data[1];
                double price = Double.parseDouble(data[2]);
                int calories = Integer.parseInt(data[3]);
                boolean vegan = Boolean.parseBoolean(data[4]);
                int quantity = Integer.parseInt(data[5]);
                String imagePath = data[6];

                MenuItem menuItem = new MenuItem(name, type, price, calories, vegan, quantity, imagePath);
                menuMap.put(name, menuItem);
            }
        }
        return menuMap;
    }
}
