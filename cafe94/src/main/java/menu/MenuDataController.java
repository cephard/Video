package menu;

import data.DataManagement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

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

        try {
            DataManagement getExcelData = new DataManagement();

            Sheet sheet = getExcelData.getSheetData("Food");

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

            getExcelData.closeFIS();
            getExcelData.closeWorkBook();
        }catch (IOException  ex) {
            ex.printStackTrace();
        }
      //  return itemData;
    }
}
