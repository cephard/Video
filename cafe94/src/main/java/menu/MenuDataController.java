package menu;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MenuDataController {
    //HashMap<String,Integer> itemsData = new HashMap<String,Integer>();


    public String getItemInfo(int rNum,int cNum,String item){
       // String itemInfo="Try " + n +" "+item;

        return getItemsData(rNum,cNum,item);
       // return itemInfo;
    }
    public double getItemPrice(String item) {
        return 0.0;
    }

    private String getItemsData(int rNum,int cNum, String item) {
        String itemData="";
       // int value=0;
       // HashMap<String,Integer> itemsData = new HashMap<String,Integer>();
        String filePath="C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Food");

            Row row;
            Cell cell;

           // int r = sheet.getLastRowNum() ;

                row = sheet.getRow(rNum);
                cell = row.getCell(cNum);
                itemData = cell.getStringCellValue();

                row=sheet.getRow(rNum+1);
                cell =row.getCell(cNum);
                       // value=Integer.parseInt(cell.getStringCellValue());
                       // itemsData.put(key,value);
                itemData = itemData +"  "+ cell.getNumericCellValue();


            fileInputStream.close();
            workbook.close();
        }catch (IOException  ex) {
            ex.printStackTrace();
        }
        return itemData;
    }
}
