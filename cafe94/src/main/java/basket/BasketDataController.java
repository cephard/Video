package basket;

import data.DataManagement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class BasketDataController {

    public void setItemsData(String UserId,String item, double price, int quantity) {
        boolean userStatus = false;
        DataManagement getExcelData = new DataManagement();
        Sheet sheet = getExcelData.getSheetData("TempBasket");

        Row row;
        Cell cell;

        int r=0;
        int c=0;

        for(int i=1;i<=sheet.getLastRowNum();i=i+3) {

            row = sheet.getRow(i);
            cell = row.getCell(0);
             if(cell.getStringCellValue().equals(UserId)) {
                 userStatus = true;
                 r=i;
                 break;
             }
        }
        if(userStatus) {
            row = sheet.getRow(r);
            // System.out.println("last row " + r);
            c = sheet.getRow(r).getLastCellNum();
            // System.out.println("last colo " +c);
            cell = row.createCell(c);
            cell.setCellValue(item);

            //Price
            row = sheet.getRow(r + 1);
            cell = row.createCell(c);
            cell.setCellValue(price);

            //Qunatity
            row = sheet.getRow(r + 2);
            cell = row.createCell(c);
            cell.setCellValue(quantity);
            userStatus = false;

        } else {

                r = sheet.getLastRowNum()+1;
                row = sheet.createRow(r);
                cell = row.createCell(0);
                cell.setCellValue(UserId);


            c = sheet.getRow(r).getLastCellNum();
            // System.out.println("last colo " +c);
            cell = row.createCell(c);
            cell.setCellValue(item);

            //Price
            row = sheet.createRow(r+1);
            cell = row.createCell(c );
            cell.setCellValue(price);

            //Qunatity
            row = sheet.createRow(r+2);
            cell = row.createCell(c);
            cell.setCellValue(quantity);
            userStatus = false;
            //setItemsData(UserId,item,price,quantity);
        }

        getExcelData.closeExcel();

    }
}
