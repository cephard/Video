package staff;

public class Employee extends Staff {
    private long clockInTime;
    private long clockOutTime;

    private static int ZERO =0;

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
        return clockInTime > ZERO;
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