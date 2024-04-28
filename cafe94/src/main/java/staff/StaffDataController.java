/**
 * This class manages the information of staff members in the Cafe Mate system,
 * including managers, chefs, waiters, and delivery drivers.
 * It provides methods for adding new staff, loading staff details,
 * and updating clock-in and clock-out times.
 */
package staff;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StaffDataController {

    // Constants for column indices in staff data file
    private static final int STAFF_ID = 1;
    private static final int FIRST_NAME = 2;
    private static final int LAST_NAME = 3;
    private static final int ROLE = 4;
    private static final int SHIFT = 5;
    private static final int IMAGE_PATH = 6;

    // Constants for column indices in attendance sheet
    private static final double BASE_CLOCK_OUT_TIME = 0.0;
    private static final int ATTENDANCE_FIRST_NAME = 0;
    private static final int ATTENDANCE_LAST_NAME = 1;
    private static final int CLOCK_IN = 3;
    private static final int CLOCK_OUT = 4;
    private static final int DATE = 5;

    /**
     * Adds a new staff member into the database.
     * This method should only be called by the manager class.
     * @param staffMap A map containing staff details.
     * @param staffDetailsPath The file path to store staff details.
     * @throws IOException If an I/O error occurs.
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
     * Loads all staff details from the database.
     *
     * @param staffDetailsPath The file path to load staff details from.
     * @return A map containing staff details.
     * @throws IOException If an I/O error occurs.
     */
    public static Map<String, Staff> loadStaffDetails(String staffDetailsPath) throws IOException {
        Map<String, Staff> staffMap = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(staffDetailsPath))) {
            String entryLine;
            reader.readLine();

            while ((entryLine = reader.readLine()) != null) {
                String[] attendanceEntry = entryLine.split(",");
                int id = Integer.parseInt(attendanceEntry[STAFF_ID]);
                String firstName = attendanceEntry[FIRST_NAME];
                String lastName = attendanceEntry[LAST_NAME];
                String role = attendanceEntry[ROLE];
                int shift = Integer.parseInt(attendanceEntry[SHIFT]);
                String imagePath = attendanceEntry[IMAGE_PATH];

                Staff staffMember = createStaffMember(id, firstName, lastName, role, shift, imagePath);
                staffMap.put(role, staffMember);
            }
        }
        return staffMap;
    }

    // selects the staff based on their role
    private static Staff createStaffMember(int id, String firstName, String lastName, String role,
                                           int shift, String imagePath) {
        switch (role.toLowerCase()) {
            case "manager":
                return new Manager(id, firstName, lastName, role, shift, imagePath);
            case "chef":
                return new Chef(id, firstName, lastName, role, shift, imagePath);
            case "waiter":
                return new Waiter(id, firstName, lastName, role, shift, imagePath);
            case "delivery driver":
                return new DeliveryDriver(id, firstName, lastName, role, shift, imagePath);
            default:
                return new Staff(id, firstName, lastName, role, shift, imagePath);
        }

    }

    /**
     * Sets the clock-in time to the current time and date for a staff member.
     *
     * @param attendanceSheetPath The file path of the attendance sheet.
     * @param staffMember         The staff member to update.
     * @throws IOException If an I/O error occurs.
     */
    public static void updateClockIn(String attendanceSheetPath, Staff staffMember) throws IOException {
        List<String> attendanceEntries = Files.readAllLines(Paths.get(attendanceSheetPath));

        for (int i = STAFF_ID; i < attendanceEntries.size(); i++) { // skipping header attendance
            String attendance = attendanceEntries.get(i);
            String[] attendanceEntry = attendance.split(",");
            attendanceEntries.set(i, String.join(",", attendanceEntry));

            //adding a new attendance if the user had already clocked out
            if (!attendanceEntry[CLOCK_OUT].equalsIgnoreCase(String.valueOf(BASE_CLOCK_OUT_TIME))){
                addNewAttendance(attendanceEntries, staffMember);
                break;
            }
        }

        // Write the updated data back to the CSV file
        Files.write(Paths.get(attendanceSheetPath), attendanceEntries);
    }


    /*
    *checks clock in time to determine if clock out tme needs to be set
     */
    private static void updateClock(String[] attendanceEntry, Staff staffMember) {
        attendanceEntry[CLOCK_IN] = staffMember.getClockIn();
        if (attendanceEntry[CLOCK_IN].equalsIgnoreCase(String.valueOf(BASE_CLOCK_OUT_TIME))
                && attendanceEntry[CLOCK_OUT].equalsIgnoreCase(String.valueOf(BASE_CLOCK_OUT_TIME))) {
            attendanceEntry[CLOCK_OUT] = String.valueOf(BASE_CLOCK_OUT_TIME);
        } else {
            staffMember.setClockOut();
            attendanceEntry[CLOCK_OUT] = staffMember.getClockOut();
        }
        attendanceEntry[DATE] = staffMember.getDate();
    }


    /**
     * Updates the clock-out time to the current time and date for a staff member.
     *
     * @param attendanceSheetPath The file path of the attendance sheet.
     * @param staffMember         The staff member to update.
     * @throws IOException If an I/O error occurs.
     */
    public static void updateClockOut(String attendanceSheetPath, Staff staffMember) throws IOException {
        List<String> attendanceEntries = Files.readAllLines(Paths.get(attendanceSheetPath));
        for (int i = STAFF_ID; i < attendanceEntries.size(); i++) { // skipping header attendance
            String attendance  = attendanceEntries.get(i);
            String[] attendanceEntry = attendance .split(",");
            if (attendanceEntry[ATTENDANCE_FIRST_NAME].equals(staffMember.getFirstName())
                    && attendanceEntry[ATTENDANCE_LAST_NAME].equals(staffMember.getLastName())
                    && attendanceEntry[CLOCK_OUT].equalsIgnoreCase(String.valueOf(BASE_CLOCK_OUT_TIME))) {
                updateClock(attendanceEntry, staffMember);
                attendanceEntries.set(i, String.join(",", attendanceEntry));
            }
        }

        // Write the updated data back to the CSV file
        Files.write(Paths.get(attendanceSheetPath), attendanceEntries);
    }


    // adding a new attendance when employee clocks in again
    private static void addNewAttendance(List<String> entryLines, Staff staffMember) {
        String newSession = String.join(",", staffMember.getFirstName(),
                staffMember.getLastName(),staffMember.getRole(),  staffMember.getClockIn(),
                String.valueOf(BASE_CLOCK_OUT_TIME), staffMember.getDate());

        entryLines.add(newSession);
    }
}

