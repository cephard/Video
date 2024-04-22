package basket;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BasketLoader {

    ArrayList<String> itemName = new ArrayList<String>();
    ArrayList<Double> itemPrice = new ArrayList<Double>();
    ArrayList<Integer> itemQunatity = new ArrayList<Integer>();

    public static String basketStatus(String userID)  {
        boolean flag = false;
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("UserData");

            Row row;
            Cell cell;

            int r = sheet.getLastRowNum() ;
            for(int i=1;i<=r;i++) {
                row = sheet.getRow(i);
                cell = row.getCell(0);
                if (cell.getStringCellValue().equals(userID)) {
                    row = sheet.getRow(i);
                    cell = row.getCell(7);
                    return cell.getStringCellValue();
                }
            }

            fileInputStream.close();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "No";
    }
    public void loadBasket(String userID, Basket basket) {
        getBasketItems(userID);
        for(int i=0;i<itemName.size(); i++) {
            basket.addItem(itemName.get(i),itemPrice.get(i),itemQunatity.get(i),0.0,false);
        }
    }
    public void getBasketItems(String userID) {
        boolean userStatus = false;
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("TempBasket");

            Row row;
            Cell cell;

            int r = 0;
            int c=0;
            for(int i=0;i<sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                cell = row.getCell(0);
                if (cell.getStringCellValue().equals(userID)) {
                    userStatus = true;
                    r=i;
                    break;
                }
            }
            if(userStatus) {
                for(int i=1;i<sheet.getRow(r).getLastCellNum();i++) {
                    //System.out.println("77    "+sheet.getRow(r).getLastCellNum());
                    row = sheet.getRow(r);
                    c = i;
                    //System.out.println("80   " +c);
                    cell = row.getCell(c);
                    itemName.add(cell.getStringCellValue());
                   // System.out.println("83   "+cell.getStringCellValue());
                    //Price
                    row = sheet.getRow((r+1));
                    cell = row.getCell(c);
                    itemPrice.add(cell.getNumericCellValue());

                    //Qunatity
                    row = sheet.getRow((r+2));
                    cell = row.getCell(c);
                    itemQunatity.add((int) cell.getNumericCellValue());
                    userStatus = false;
                }
            }

            fileInputStream.close();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void storeOrder(String userID, String orderList) {
        boolean userStatus =false;
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("OrderHistory");

            Row row;
            Cell cell=null;

            int r=0;
            int c=0;
            for(int i=0;i<sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                cell = row.getCell(0);
                if (cell.getStringCellValue().equals(userID)) {
                    userStatus = true;
                    r=i;
                    break;
                }
            }
            if(userStatus) {
                    row = sheet.getRow(r);
                    c = row.getLastCellNum();
                    cell = row.createCell(c);
                    cell.setCellValue(orderList);
            } else {
                r=sheet.getLastRowNum()+1;
                row=sheet.createRow(r);
                cell = row.createCell(0);
                cell.setCellValue(userID);

                //List
                row = sheet.getRow(r);
                cell = row.createCell(1 );
                cell.setCellValue(orderList);
            }

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            // Close streams
            fileInputStream.close();
            fileOutputStream.close();

            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void changeBasketStatus(String userID,String status) {
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("UserData");

            Row row;
            Cell cell;

            int r = sheet.getLastRowNum() ;
            for(int i=1;i<=r;i++) {
                row = sheet.getRow(i);
                cell = row.getCell(0);
                if (cell.getStringCellValue().equals(userID)) {
                    row=sheet.getRow(i);
                    cell=row.getCell(7);
                    cell.setCellValue(status);
                    break;
                }
            }

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            // Close streams
            fileInputStream.close();
            fileOutputStream.close();

            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void deleteTempBasket(String userID) {
        boolean userStatus=false;
        String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("TempBasket");

            Row row;
            Cell cell;
            int r=0;
            int c=0;
            for(int i=0;i<=sheet.getLastRowNum();i=i+3) {
                row = sheet.getRow(i);
                cell = row.getCell(0);
                if(cell.getStringCellValue().equals(userID)) {
                    //userStatus = true;
                    r=i;
                    break;
                }
            }
            int l=sheet.getRow(r).getLastCellNum();


            row= sheet.getRow(r);
            sheet.removeRow(row);
            row= sheet.getRow(r+1);
            sheet.removeRow(row);
            row= sheet.getRow(r+2);
            sheet.removeRow(row);


            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);

            // Close streams
            fileInputStream.close();
            fileOutputStream.close();

            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
