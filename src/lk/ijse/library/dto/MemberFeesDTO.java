package lk.ijse.library.dto;

public class MemberFeesDTO {
   private String feesId ;
   private String memberId ;
     private String month ;
   private double amount;
  private String  acceptDate ;
  private String  acceptBy ;

    public MemberFeesDTO() {
    }

    public MemberFeesDTO(String feesId, String memberId, String month, double amount, String acceptDate) {
        this.feesId = feesId;
        this.memberId = memberId;
        this.month = month;
        this.amount = amount;
        this.acceptDate = acceptDate;
    }

    public MemberFeesDTO(String feesId, String memberId, String month, double amount, String acceptDate, String acceptBy) {
        this.feesId = feesId;
        this.memberId = memberId;
        this.month = month;
        this.amount = amount;
        this.acceptDate = acceptDate;
        this.acceptBy = acceptBy;
    }

    public String getFeesId() {
        return feesId;
    }

    public void setFeesId(String feesId) {
        this.feesId = feesId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(String acceptBy) {
        this.acceptBy = acceptBy;
    }
}
