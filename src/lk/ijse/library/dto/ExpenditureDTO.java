package lk.ijse.library.dto;

public class ExpenditureDTO {
   private String expenditureId ;
  private String  description ;
   private double amount ;
    private String date ;
        private String addBy;

    public ExpenditureDTO() {
    }

    public ExpenditureDTO(String expenditureId, String description, double amount, String date, String addBy) {
        this.expenditureId = expenditureId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.addBy = addBy;
    }

    public ExpenditureDTO(String expenditureId, String description, double amount, String date) {
        this.expenditureId = expenditureId;
        this.description = description;
        this.amount = amount;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }
}
