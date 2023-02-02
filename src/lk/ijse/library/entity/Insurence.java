package lk.ijse.library.entity;

import java.sql.Date;

public class Insurence {
    private String insurenceId;
    private String insurenceType;
private Date payDate;
private Date renewDate;
private double anualPayment;
private String acceptBy;

    public Insurence() {
    }

    public Insurence(String insurenceId, String insurenceType, Date payDate, Date renewDate, double anualPayment, String acceptBy) {
        this.insurenceId = insurenceId;
        this.insurenceType = insurenceType;
        this.payDate = payDate;
        this.renewDate = renewDate;
        this.anualPayment = anualPayment;
        this.acceptBy = acceptBy;
    }

    public Insurence(String insurenceType, Date payDate, Date renewDate, double anualPayment) {
        this.insurenceType = insurenceType;
        this.payDate = payDate;
        this.renewDate = renewDate;
        this.anualPayment = anualPayment;
    }

    public Insurence(String insurenceType, Date payDate, Date renewDate, double anualPayment, String acceptBy) {
        this.insurenceType = insurenceType;
        this.payDate = payDate;
        this.renewDate = renewDate;
        this.anualPayment = anualPayment;
        this.acceptBy = acceptBy;
    }

    public String getInsurenceId() {
        return insurenceId;
    }

    public void setInsurenceId(String insurenceId) {
        this.insurenceId = insurenceId;
    }

    public String getInsurenceType() {
        return insurenceType;
    }

    public void setInsurenceType(String insurenceType) {
        this.insurenceType = insurenceType;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    public double getAnualPayment() {
        return anualPayment;
    }

    public void setAnualPayment(double anualPayment) {
        this.anualPayment = anualPayment;
    }

    public String getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(String acceptBy) {
        this.acceptBy = acceptBy;
    }
}
