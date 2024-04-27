package login;
import java.util.HashMap;

public class UserData {
    HashMap<String, String> userName = new HashMap<String, String>();
    HashMap<String, String> userPass = new HashMap<String, String>();


    public UserData(){
       userName.put("1001","Kiran");
       userName.put("1002","Ceph");
       userName.put("1003","Sai");
       userName.put("1004","Haya");
       userName.put("1005","Beth");
       userPass.put("1","admin");

    }
    public boolean checkUser(String uId) {

        return userName.containsKey(uId);
    }
    public boolean checkUserPass(String uPass) {

        return userPass.containsValue(uPass);
    }
    
    public String getUserName(String uId) {

        return userName.get(uId);
    }
    public HashMap<String, String> getUserName() {

        return userName;
    }
    public HashMap<String, String> getUserPass() {
        return userPass;
    }
    public void setUserData(HashMap<String, String> userName,HashMap<String, String> userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
}
