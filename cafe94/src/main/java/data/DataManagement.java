package data;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataManagement {

    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    Workbook workbook;
    Sheet sheet;
    public final String filePath = "cafe94/src/main/java/data/Data.xlsx";

    public  void setSheet(String sheetName) {
        //String filePath = "C:/Users/kiran/Projects/Cafe94/cafe94/src/main/java/login/Data.xlsx";
        try{
            this.fileInputStream = new FileInputStream(new File(this.filePath));
            this.workbook = WorkbookFactory.create(this.fileInputStream);
            this.sheet = this.workbook.getSheet(sheetName);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public Sheet getSheetData(String sheetName) {
        setSheet(sheetName);
        return this.sheet;
    }
    public void writing() throws IOException {
        try {
            this.fileOutputStream = new FileOutputStream(this.filePath);
            workbook.write(this.fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFIS() throws IOException {
        fileInputStream.close();
    }
    public void closeFOS() throws IOException {
        fileOutputStream.close();
    }
    public void closeWorkBook() throws IOException {
        workbook.close();
    }

    public void closeExcel() {

        try {
            writing();
            closeFIS();
            closeFOS();
            closeWorkBook();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
