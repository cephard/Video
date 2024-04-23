package login;

import data.DataManagement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class CustomerLoginController {

    public static  ArrayList<String> userData = new ArrayList<>();
//    public boolean checkUser(String uId) {
//        boolean result = false;
//        return result;
//    }
//    public boolean checkUserPass(String uPass) {
//        boolean result = false;
//       return result;
//    }

    public static String getUserName() {
        return userData.get(1)+" "+userData.get(2);
    }
    public static String getUserID(){
        return userData.get(0);
    }
    public static boolean checkUserData(String regID,String password)  {
        boolean flag = false;

        DataManagement getExcelData = new DataManagement();

        Sheet sheet = getExcelData.getSheetData("UserData");
        Row row;
        Cell cell;

        int r = sheet.getLastRowNum() ;
        for(int i=1;i<=r;i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            if (cell.getStringCellValue().equals(regID)) {

               for(int j=0;j<7;j++) {
                   row=sheet.getRow(i);
                   cell =row.getCell(j);
                   userData.add(cell.getStringCellValue());
               }
                row = sheet.getRow(i);
                cell = row.getCell(6);
                return cell.getStringCellValue().equals(password);
            }
        }

        getExcelData.closeExcel();

        return false;
    }


}
