
package staff;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Staff {
    private final LocalDate date;
    private String firstName;
    private String lastName;
    private String role;
    private int shift;
    private final String imagePath;
    private int totalShiftHours;
    int id;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;

    /**
     * Constructs a new Staff object.
     * @param id The unique identifier of the staff member.
     * @param firstName The first name of the staff member.
     * @param lastName The last name of the staff member.
     * @param role The role of the staff member.
     * @param shift The shift duration of the staff member.
     * @param imagePath The path to the staff member's image.
     */
    public Staff(int id,String firstName,String lastName, String role,
                 int shift, String imagePath) {
        this.id =id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.shift = shift;
        this.imagePath = imagePath;
        this.date = LocalDate.now();
    }

    public void setItemImage(String itemImagePath) {

    }

    public String getImagePath() {
        return imagePath;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public  String getFirstName(){
        return firstName;
    }
    public  String getLastName(){
        return lastName;
    }
    public void setName(String firstName, String lastName) {
        this.firstName= firstName;
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setType(String type) {
        this.role = role;
    }

    public int getShift() {
        return shift;
    }


    public void setShift(int shift) {
        this.shift = shift;
    }


    public void addHours(int shiftHours) {
        this.totalShiftHours += shiftHours;
    }
    

    public void addOverTime(int overTime){
        this.shift += overTime;
    }

    /**
     * Sets the clock-in time for the staff member.
     * @param clockInTime The time the staff member clocked in.
     */
    public void clockIn(LocalTime clockInTime){
        this.clockInTime =clockInTime;
    }

    /**
     * Gets the formatted clock-in time of the staff member.
     * @return The formatted clock-in time.
     */
    public String getClockIn(){
        return clockInTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    /**
     * accessing current date in form of string
     * @return Current date
     */
    //returning date in form of  string to easily save and retrieve into CSV
    public String getDate() {
        return date.toString();
    }

    /**
     * Sets the clock-out time for the staff member.
     */
    public void setClockOut(){
        this.clockOutTime = LocalTime.now();
    }

    /**
     * Gets the formatted clock-out time of the staff member.
     * @return The formatted clock-out time.
     */
    public String getClockOut(){
        return clockOutTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}


