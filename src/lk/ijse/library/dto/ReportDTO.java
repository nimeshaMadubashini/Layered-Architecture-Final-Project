package lk.ijse.library.dto;

public class ReportDTO {
  private String  reportNum;
    private String  startDate;
   private String getBy;

    public ReportDTO() {
    }

    public ReportDTO(String reportNum, String startDate, String getBy) {
        this.reportNum = reportNum;
        this.startDate = startDate;
        this.getBy = getBy;
    }

    public ReportDTO(String reportNum, String startDate) {
        this.reportNum = reportNum;
        this.startDate = startDate;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGetBy() {
        return getBy;
    }

    public void setGetBy(String getBy) {
        this.getBy = getBy;
    }
}
