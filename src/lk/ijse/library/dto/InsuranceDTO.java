package lk.ijse.library.dto;

public class InsuranceDTO {
  private String  insurenceId;
 private String   insurenceType;
 private String   payDate ;
 private String   renewDate ;
 private double   anualPayment ;
 private String   acceptBy;

    public InsuranceDTO() {
    }

    public InsuranceDTO(String insurenceId, String insurenceType, String payDate, String renewDate, double anualPayment) {
        this.insurenceId = insurenceId;
        this.insurenceType = insurenceType;
        this.payDate = payDate;
        this.renewDate = renewDate;
        this.anualPayment = anualPayment;
    }

    public InsuranceDTO(String insurenceId, String insurenceType, String payDate, String renewDate, double anualPayment,
                        String acceptBy) {
        this.insurenceId = insurenceId;
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

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(String renewDate) {
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
