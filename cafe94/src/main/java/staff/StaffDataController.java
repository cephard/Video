/**
 * Class that handles information of all the staff members in
 * Cafe Mate system.
 * These include manager, chef , waiter and delivery driver
 */

// for the sake of this partial design we will use one employee on each role
package staff;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StaffDataController {

    private static final int HEADER = 0 ;
    private static final  int STAFF_ID = 1;
    private static final int FIRST_NAME =2;
    private static final int LAST_NAME = 3;
    private static final int ROLE = 4;
    private static final int SHIFT = 5;
    private static final int IMAGE_PATH = 6;

    private static final int CLOCK_IN = 3;
    private static final int CLOCK_OUT = 4;
    private static final int DATE = 5;
    private static final double BASE_CLOCK_OUT_TIME = 0.0;



    /**
     * Adding a new staff member into the database
     * @param staffMap
     * @param staffDetailsPath
     * @throws IOException
     */
    //this method should only be called in the manager class
    public static void addNewStaff(Map<String, Staff> staffMap, String staffDetailsPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(staffDetailsPath))) {
            writer.write("name,role,shift,imagePath");
            writer.newLine();
            for (Staff staffMember : staffMap.values()) {
                writer.write(String.format("%s,%s,%s,%s",
                        staffMember.getName(), staffMember.getRole(), staffMember.getShift(),
                        staffMember.getImagePath()));
                writer.newLine();
            }
        }
    }


    /**
     * Getting all the staff details from the database
     * @param staffDetailsPath
     * @return
     * @throws IOException
     */
    public static Map<String, Staff> loadStaffDetails(String staffDetailsPath) throws IOException {
        Map<String, Staff> staffMap = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(staffDetailsPath))) {
            String entryLine;
            reader.readLine();

            while ((entryLine = reader.readLine()) != null) {
                String[] entryPart = entryLine.split(",");
                int id = Integer.parseInt(entryPart[STAFF_ID]);
                String firstName = entryPart[FIRST_NAME];
                String lastName = entryPart[LAST_NAME];
                String role = entryPart[ROLE];
                int shift = Integer.parseInt(entryPart[SHIFT]);
                String imagePath = entryPart[IMAGE_PATH];

                Staff staffMember = new Staff(id, firstName, lastName, role,shift,imagePath);
                staffMap.put(role, staffMember);
            }
        }
        return staffMap;
    }


    /**
     * Sets the clock in time to current time and date
     * @param attendanceSheetPath
     * @param staffMember
     * @throws IOException
     */
    public static void updateClockIn(String attendanceSheetPath, Staff staffMember) throws IOException {
        List<String> entryLines = Files.readAllLines(Paths.get(attendanceSheetPath));

        for (int i = 1; i < entryLines.size(); i++) { // skipping header entryLine
            String entryLine = entryLines.get(i);
            String[] entryPart = entryLine.split(",");
            entryLines.set(i, String.join(",", entryPart));

            //adding a new attendance if the user had already clocked out
            if (!entryPart[CLOCK_OUT].equalsIgnoreCase(String.valueOf(0.0))){
                addNewAttendance(entryLines, staffMember);
                break;
            }
        }

        // Write the updated data back to the CSV file
        Files.write(Paths.get(attendanceSheetPath), entryLines);
    }


    /**
     * checks clock in time to determine if clock out tme needs to be set
     * @param entryPart
     * @param staffMember
     */
    private static void updateClock(String[] entryPart, Staff staffMember) {
        entryPart[CLOCK_IN] = staffMember.getClockIn();
        if (entryPart[CLOCK_IN].equalsIgnoreCase(String.valueOf(0.0))
                && entryPart[CLOCK_OUT].equalsIgnoreCase(String.valueOf(0.0))) {
            entryPart[CLOCK_OUT] = String.valueOf(0.0);
        } else {
            staffMember.setClockOut();
            entryPart[CLOCK_OUT] = staffMember.getClockOut();
        }
        entryPart[DATE] = staffMember.getDate();
    }


    /**
     * updates clock out time to current time
     * @param attendanceSheetPath
     * @param staffMember
     * @throws IOException
     */
    public static void updateClockOut(String attendanceSheetPath, Staff staffMember) throws IOException {
        List<String> entryLines = Files.readAllLines(Paths.get(attendanceSheetPath));
        for (int i = 1; i < entryLines.size(); i++) { // skipping header line
            String line = entryLines.get(i);
            String[] entryParts = line.split(",");
            if (entryParts[0].equals(staffMember.getFirstName())
                    && entryParts[1].equals(staffMember.getLastName())
                    && entryParts[CLOCK_OUT].equalsIgnoreCase(String.valueOf(0.0))) {
                updateClock(entryParts, staffMember);
                entryLines.set(i, String.join(",", entryParts));
                break;
            }
        }

        // Write the updated data back to the CSV file
        Files.write(Paths.get(attendanceSheetPath), entryLines);
    }


    /**
     * adding a new attendance when employee clocks in again
     * @param entryLines
     * @param staffMember
     */
    private static void addNewAttendance(List<String> entryLines, Staff staffMember) {
        String newSession = String.join(",", staffMember.getFirstName(), staffMember.getLastName(),staffMember.getRole(),  staffMember.getClockIn(), String.valueOf(0.0), staffMember.getDate());
        entryLines.add(newSession);
    }
}
