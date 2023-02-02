package lk.ijse.library.entity;

import java.sql.Date;

public class Newspaper {
    private String newsPaperId;
    private String title;
    private int qty;
    private Date date;
    private String accceptBy;
    private String supplyBy;

    public Newspaper() {
    }

    public Newspaper(String newsPaperId, String title, int qty, Date date, String supplyBy) {
        this.newsPaperId = newsPaperId;
        this.title = title;
        this.qty = qty;
        this.date = date;
        this.supplyBy = supplyBy;
    }

    public Newspaper(String newsPaperId, String title, int qty, Date date, String accceptBy, String supplyBy) {
        this.newsPaperId = newsPaperId;
        this.title = title;
        this.qty = qty;
        this.date = date;
        this.accceptBy = accceptBy;
        this.supplyBy = supplyBy;
    }



    public String getNewsPaperId() {
        return newsPaperId;
    }

    public void setNewsPaperId(String newsPaperId) {
        this.newsPaperId = newsPaperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccceptBy() {
        return accceptBy;
    }

    public void setAccceptBy(String accceptBy) {
        this.accceptBy = accceptBy;
    }

    public String getSupplyBy() {
        return supplyBy;
    }

    public void setSupplyBy(String supplyBy) {
        this.supplyBy = supplyBy;
    }
}
