package lk.ijse.library.dto;

public class NewsPaperDTO {
   private String newsPaperId ;
  private String  title;
  private int  qty;
    private String date;
   private String acceptBy;
    private String supplyBy;

    public NewsPaperDTO() {
    }

    public NewsPaperDTO(String newsPaperId, String title, int qty, String date, String supplyBy) {
        this.newsPaperId = newsPaperId;
        this.title = title;
        this.qty = qty;
        this.date = date;
        this.supplyBy = supplyBy;
    }

    public NewsPaperDTO(String newsPaperId, String title, int qty, String date, String acceptBy, String supplyBy) {
        this.newsPaperId = newsPaperId;
        this.title = title;
        this.qty = qty;
        this.date = date;
        this.acceptBy = acceptBy;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(String acceptBy) {
        this.acceptBy = acceptBy;
    }

    public String getSupplyBy() {
        return supplyBy;
    }

    public void setSupplyBy(String supplyBy) {
        this.supplyBy = supplyBy;
    }
}
