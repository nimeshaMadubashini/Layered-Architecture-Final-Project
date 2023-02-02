package lk.ijse.library.dto;

import com.jfoenix.controls.JFXTextField;

public class BookSupplyDetailsDTO {
  private String  supplyId ;
   private String BookId ;
   private String granterId ;
   private int supplyQty ;
    private double unitPrice;
   private double total;
  private String  supplyDate;

    public BookSupplyDetailsDTO(String supplyId, String bookId, String granterId, int supplyQty, double unitPrice, JFXTextField txtTotal, String supplyDate) {
    }

    public BookSupplyDetailsDTO(String supplyId, String bookId, String granterId, int supplyQty, double unitPrice, double total, String supplyDate) {
        this.supplyId = supplyId;
        BookId = bookId;
        this.granterId = granterId;
        this.supplyQty = supplyQty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.supplyDate = supplyDate;
    }

    public String getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getGranterId() {
        return granterId;
    }

    public void setGranterId(String granterId) {
        this.granterId = granterId;
    }

    public int getSupplyQty() {
        return supplyQty;
    }

    public void setSupplyQty(int supplyQty) {
        this.supplyQty = supplyQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(String supplyDate) {
        this.supplyDate = supplyDate;
    }
}
