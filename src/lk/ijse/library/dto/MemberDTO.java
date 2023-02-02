package lk.ijse.library.dto;

import java.time.LocalDate;

public class MemberDTO {
  private String  memberId ;
  private String  name ;
   private String email ;
    private String address  ;
  private int  telephoneNumber ;
   private String registerDate ;

    public MemberDTO() {
    }

    public MemberDTO(String memberId, String name, String email, String address, int teleNum, LocalDate date) {
    }

    public MemberDTO(String memberId, String name, String email, String address, int telephoneNumber, String registerDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.registerDate = registerDate;
    }

    public MemberDTO(String memberId, String name, String email, String address, int telephoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public MemberDTO(String memberId, String name, String email, String address, int telephoneNumber, String registerDate, String registeredBy) {
        this.setMemberId(memberId);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setTelephoneNumber(telephoneNumber);
        this.setRegisterDate(registerDate);
        this.setRegisteredBy(registeredBy);
    }

    private String  registeredBy  ;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }
}
