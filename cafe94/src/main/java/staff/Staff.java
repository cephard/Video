package staff;

public class Staff {
    private int staffId;
    private String firstName;
    private String lastName;
    private int shiftLength;
    private String role;
    private int totalShiftHours;

    public Staff(int staffId, String firstName, String lastName, String role) {
        this.staffId =staffId;
        this.firstName =firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public void addHours(int shiftHours) {
        this.totalShiftHours += shiftHours;
    }

    public void setShiftLength(int shiftLength) {
        this.shiftLength = shiftLength;
    }

    public int getShiftLength() {
        return shiftLength;
    }

    public void addOverTime(int overTime){
        this.shiftLength += overTime;
    }
}
