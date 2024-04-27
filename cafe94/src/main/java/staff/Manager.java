package staff;

import java.util.ArrayList;

public class Manager extends Staff {
    private ArrayList<StaffDataController> staffCover;

    public Manager(int id, String firstName, String lastName, String role,int shift,String imagePath) {
        super(id, firstName, lastName, role,shift,imagePath);
        this.staffCover = new ArrayList<>();
    }

    public void addStaff(StaffDataController newStaff) {
        staffCover.add(newStaff);
    }

    public void removeStaff(StaffDataController Staff) {
        staffCover.remove(Staff);
    }

    public ArrayList<StaffDataController> getStaffCover() {
        return staffCover;
    }

    public void editStaffDetails() {

    }

}