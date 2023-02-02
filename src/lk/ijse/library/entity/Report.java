package lk.ijse.library.entity;

import java.sql.Date;

public class Report {
    private String reportNum;
    private Date startDate;
    private String getBy;

    public Report() {
    }

    public Report(String reportNum, Date startDate, String getBy) {
        this.reportNum = reportNum;
        this.startDate = startDate;
        this.getBy = getBy;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getGetBy() {
        return getBy;
    }

    public void setGetBy(String getBy) {
        this.getBy = getBy;
    }
}
