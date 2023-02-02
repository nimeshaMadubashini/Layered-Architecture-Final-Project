package lk.ijse.library.entity;

import java.sql.Date;

public class Expenditure {
    private String expenditureId;
    private  String description;
    private double amount;
    private Date Date;
    private String addBy;

    public Expenditure() {
    }

    public Expenditure(String expenditureId, String description, double amount, java.sql.Date date) {
        this.expenditureId = expenditureId;
        this.description = description;
        this.amount = amount;
        Date = date;
    }

    public Expenditure(String expenditureId, String description, double amount, java.sql.Date date, String addBy) {
        this.expenditureId = expenditureId;
        this.description = description;
        this.amount = amount;
        Date = date;
        this.addBy = addBy;
    }

    public String getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(String expenditureId) {
        this.expenditureId = expenditureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }
}
