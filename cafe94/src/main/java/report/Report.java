package report;

import staff.Staff;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a report containing a list of staff members and their hours worked.
 */
public class Report {
    private final Date reportDate;
    private ArrayList<Staff> report;
    private int reportId;

    /**
     * Constructs a Report object.
     */
    public Report() {
        this.report = new ArrayList<>();
        this.reportId = reportId;
        this.reportDate = new Date();
    }


    /**
     * Calculates the total hours worked by all staff members in the report.
     *
     * @return The total hours worked in the report.
     */
    public int getTotalHours() {
        int totalHours = 0;
        for (Staff staff : report) {
            totalHours += staff.getHours();
        }
        return totalHours;
    }

    /**
     * Retrieves all staff members included in the report.
     *
     * @return A list of all staff members in the report.
     */
    public ArrayList<Staff> getReport() {
        return new ArrayList<>(report);
    }

    /**
     * Retrieves the ID of the report.
     *
     * @return The ID of the report.
     */
    public int getReportId() {
        return reportId;
    }

    /**
     * Checks if the report is empty.
     *
     * @return True if the report is empty, false otherwise.
     */
    public boolean isEmpty() {
        return report.isEmpty();
    }

    /**
     * Formats the given date object to a string in "yyyy-MM-dd" format.
     *
     * @param date The date object to format.
     * @return The formatted date string.
     */
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
