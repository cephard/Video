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
    private static final String DATA_FILE_PATH = "cafe94/src/main/java/data/Data.xlsx";

    public  void setSheet(String sheetName) {
        try{
            this.fileInputStream = new FileInputStream(new File(this.DATA_FILE_PATH));
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
            this.fileOutputStream = new FileOutputStream(this.DATA_FILE_PATH);
            workbook.write(this.fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFIS() throws IOException {

        try {
            fileInputStream.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeFOS() throws IOException {
        fileOutputStream.close();
    }
    public void closeWorkBook() throws IOException {
        try {
            workbook.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

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
