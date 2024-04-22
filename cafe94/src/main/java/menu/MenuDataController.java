package menu;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MenuDataController {
    //HashMap<String,Integer> itemsData = new HashMap<String,Integer>();

    public String name;
    public double price;

    public String getItemInfo(int rNum,int cNum,String item){
       // String itemInfo="Try " + n +" "+item;

         setItemsData(rNum,cNum,item);
        return name;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {

        return price;
    }

    public void setItemsData(int rNum,int cNum, String item) {
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
                this.name=cell.getStringCellValue();
                row=sheet.getRow(rNum+1);
                cell =row.getCell(cNum);
                       // value=Integer.parseInt(cell.getStringCellValue());
                       // itemsData.put(key,value);
                itemData = itemData +"  "+ cell.getNumericCellValue();
                this.price=cell.getNumericCellValue();

            fileInputStream.close();
            workbook.close();
        }catch (IOException  ex) {
            ex.printStackTrace();
        }
      //  return itemData;
    }
}
