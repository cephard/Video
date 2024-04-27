/**
 *
 */

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



    public Staff(int id,String firstName,String lastName, String role, int shift, String imagePath) {
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

    public void clockIn(LocalTime clockInTime){
        this.clockInTime =clockInTime;
    }

    public String getClockIn(){
        return clockInTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    /**
     * accessing current date in form of string
     * @return
     */
    //returning date in form of  string to easily save and retrieve into CSV
    public String getDate() {
        return date.toString();
    }

    public void setClockOut(){
        this.clockOutTime = LocalTime.now();
    }

    public String getClockOut(){
        return clockOutTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}


