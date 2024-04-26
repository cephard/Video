/**
 * The BasketLoader class is responsible for loading and managing user baskets from Excel sheets.
 */

package basket;

import data.DataManagement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.util.ArrayList;

public class BasketLoader {

    //storing item details in arraylists
    ArrayList<String> itemName = new ArrayList<String>();
    ArrayList<Double> itemPrice = new ArrayList<Double>();
    ArrayList<Integer> itemQuantity = new ArrayList<Integer>();

    Sheet sheet;
    DataManagement getExcelData = new DataManagement();

    //constants
    private static final double DISCOUNT  = 0.0;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 7;
    private static final int SECOND_INDEX = 1;
    private static final int INCREMENT_INDEX_ONCE = 1;
    private static final int INCREMENT_INDEX_TWICE = 2;
    private static final int INCREMENT_INDEX_THRICE = 3;

    /**
     * Retrieves the basket status for a given user.
     *
     * @param userID The ID of the user whose basket status is to be retrieved.
     * @return The basket status for the given user.
     */

    // If the items were added into the basket and the system exited
    // before the purchase was complete the saved data will be retrieved
    public  String basketStatus(String userID)  {
        boolean flag = false;

        try {
            this.sheet=getExcelData.getSheetData("UserData");
            Row row;
            Cell cell;

            int r = sheet.getLastRowNum() ;
            for(int i=SECOND_INDEX;i<=r;i++) {
                row = sheet.getRow(i);
                cell = row.getCell(FIRST_INDEX);
                if (cell.getStringCellValue().equals(userID)) {
                    row = sheet.getRow(i);
                    cell = row.getCell(LAST_INDEX);
                    return cell.getStringCellValue();
                }
            }
            getExcelData.closeFIS();
            getExcelData.closeWorkBook();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "No";
    }

    /**
     * Loads the basket for a given user into a Basket object.
     *
     * @param userID The ID of the user whose basket is to be loaded.
     * @param basket The Basket object to which the items are loaded.
     */
    public void loadBasket(String userID, Basket basket) {
        getBasketItems(userID);
        for(int i = FIRST_INDEX; i<itemName.size(); i++) {
            basket.addItem(itemName.get(i),itemPrice.get(i), itemQuantity.get(i),DISCOUNT,false);
        }
    }

    /**
     * Retrieves the items in the basket for a given user.
     *
     * @param userID The ID of the user whose basket items are to be retrieved.
     */
    public void getBasketItems(String userID) {
        boolean userStatus = false;

        try {
            this.sheet=getExcelData.getSheetData("TempBasket");
            Row row;
            Cell cell;

            int r = FIRST_INDEX;
            int c= FIRST_INDEX;
            for(int i = 1; i<sheet.getLastRowNum(); i = i+3) {
                row = sheet.getRow(i);
                cell = row.getCell(0);
                if (cell.getStringCellValue().equals(userID)) {
                    userStatus = true;
                    r=i;
                    break;
                }
            }
            if(userStatus) {
                for(int i=SECOND_INDEX;i<sheet.getRow(r).getLastCellNum();i++) {
                    row = sheet.getRow(r);
                    c = i;
                    cell = row.getCell(c);
                    itemName.add(cell.getStringCellValue());

                    //Price
                    row = sheet.getRow((r+INCREMENT_INDEX_ONCE));
                    cell = row.getCell(c);
                    itemPrice.add(cell.getNumericCellValue());

                    //Qunatity
                    row = sheet.getRow((r+INCREMENT_INDEX_TWICE));
                    cell = row.getCell(c);
                    itemQuantity.add((int) cell.getNumericCellValue());
                    userStatus = false;
                }
            }

            getExcelData.closeFIS();
            getExcelData.closeWorkBook();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Stores the order history for a given user.
     *
     * @param userID    The ID of the user for whom the order history is to be stored.
     * @param orderList The list of orders to be stored.
     */
    public void storeOrder(String userID, String orderList) {
        boolean userStatus =false;

        this.sheet=getExcelData.getSheetData("OrderHistory");
        Row row;
        Cell cell=null;

        int newRow = FIRST_INDEX;
        int newColumn = FIRST_INDEX;
        for(int i = FIRST_INDEX; i<sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            cell = row.getCell(FIRST_INDEX);
            if (cell.getStringCellValue().equals(userID)) {
                userStatus = true;
                newRow=i;
                break;
            }
        }
        if(userStatus) {
                row = sheet.getRow(newRow);
                newColumn = row.getLastCellNum();
                cell = row.createCell(newColumn);
                cell.setCellValue(orderList);
        } else {
            newRow=sheet.getLastRowNum()+INCREMENT_INDEX_ONCE;
            row=sheet.createRow(newRow);
            cell = row.createCell(FIRST_INDEX);
            cell.setCellValue(userID);

            //List
            row = sheet.getRow(newRow);
            cell = row.createCell(SECOND_INDEX );
            cell.setCellValue(orderList);
        }
        getExcelData.closeExcel();
    }


    /**
     * Changes the status of the user's basket.
     *
     * @param userID The ID of the user whose basket status is to be changed.
     * @param status The new status to be set for the basket.
     */
    public void changeBasketStatus(String userID,String status) {
        this.sheet=getExcelData.getSheetData("UserData");
        Row row;
        Cell cell;

        int lastRow = sheet.getLastRowNum() ;
        for(int i=SECOND_INDEX;i<=lastRow;i++) {
            row = sheet.getRow(i);
            cell = row.getCell(FIRST_INDEX);
            if (cell.getStringCellValue().equals(userID)) {
                row=sheet.getRow(i);
                cell=row.getCell(LAST_INDEX);
                cell.setCellValue(status);
                break;
            }
        }

        getExcelData.closeExcel();

    }

    /**
     * Deletes the temporary basket for a given user.
     *
     * @param userID The ID of the user whose temporary basket is to be deleted.
     */
    public void deleteTempBasket(String userID) {
        boolean userStatus=false;
        this.sheet=getExcelData.getSheetData("TempBasket");
        Row row;
        Cell cell;
        int currentRow= FIRST_INDEX;
        //int currentColumn= FIRST_INDEX;
        for(int i = FIRST_INDEX; i<=sheet.getLastRowNum(); i=i+INCREMENT_INDEX_THRICE) {
            row = sheet.getRow(i);
            cell = row.getCell(FIRST_INDEX);
            if(cell.getStringCellValue().equals(userID)) {
                currentRow=i;
                break;
            }
        }

        row= sheet.getRow(currentRow);
        sheet.removeRow(row);
        row= sheet.getRow(currentRow+INCREMENT_INDEX_ONCE);
        sheet.removeRow(row);
        row= sheet.getRow(currentRow+INCREMENT_INDEX_TWICE);
        sheet.removeRow(row);
        getExcelData.closeExcel();

    }

}
