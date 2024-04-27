package staff;

import java.util.ArrayList;

public class Employee extends Staff {
    private long clockInTime;
    private long clockOutTime;

    public Employee(int id, String firstName, String lastName, String role,int shift,String imagePath) {
        super(id, firstName, lastName, role,shift,imagePath);
    }

    public void clockIn() {
        clockInTime = System.currentTimeMillis();
    }

    public void clockOut() {
        clockOutTime = System.currentTimeMillis();
    }

    public boolean hasClockedIn() {
        return clockInTime > 0;
    }

    public boolean hasClockedOut() {
        return clockOutTime > clockInTime;
    }

    public long getClockedInTime() {
        return clockInTime;
    }

    public long getClockedOutTime() {
        return clockOutTime;
    }
}