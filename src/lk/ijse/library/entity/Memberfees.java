package lk.ijse.library.entity;

import java.sql.Date;

public class Memberfees {
    private String feesId;
    private  String memberId;
    private  String month;
    private  double amount;
    private  Date acceptDate;
    private String acceptBy;

    public Memberfees() {
    }

    public Memberfees(String feesId, String memberId, String month, double amount, Date acceptDate, String acceptBy) {
        this.feesId = feesId;
        this.memberId = memberId;
        this.month = month;
        this.amount = amount;
        this.acceptDate = acceptDate;
        this.acceptBy = acceptBy;
    }

    public Memberfees(String feesId, String memberId, String month, double amount, Date acceptDate) {
        this.feesId = feesId;
        this.memberId = memberId;
        this.month = month;
        this.amount = amount;
        this.acceptDate = acceptDate;
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

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(String acceptBy) {
        this.acceptBy = acceptBy;
    }
}
