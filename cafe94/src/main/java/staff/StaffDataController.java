package staff;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class StaffDataController {

    //saving menu items to csv file

    /**
     *
     * @param staffMap
     * @param filePath
     * @throws IOException
     */
    public static void saveMenuToDataBase(Map<String, StaffMember> staffMap, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name,Type,Price,Calories,Vegan,Quantity,ImagePath");
            writer.newLine();
            for (StaffMember staffMember : staffMap.values()) {
                writer.write(String.format("%s,%s,%.2f,%d,%b,%d,%s",
                        staffMember.getName(), staffMember.getRole(), staffMember.getShift(),
                        staffMember.getImagePath()));
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
    public static Map<String, StaffMember> loadMenuFromCSV(String filePath) throws IOException {
        Map<String, StaffMember> staffMap = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String role = data[1];
                int shift = Integer.parseInt(data[2]);
                String imagePath = data[3];

                StaffMember staffMember = new StaffMember(name, role, shift, imagePath);
                staffMap.put(name, staffMember);
            }
        }
        return staffMap;
    }
}
