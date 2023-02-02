package lk.ijse.library.entity;

import java.sql.Date;

public class Member {

        private String memberId;
        private String name;
        private String email;
        private String address;
        private  int telephoneNumber;
        private Date registerDate;
        private  String registeredBy;

    public Member() {
    }

    public Member(String memberId, String name, String email, String address, int telephoneNumber, Date registerDate, String registeredBy) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.registerDate = registerDate;
        this.registeredBy = registeredBy;
    }

    public Member(String memberId, String name, String email, String address, int telephoneNumber, Date registerDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.registerDate = registerDate;
    }

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

        public Date getRegisterDate() {
        return registerDate;
    }

        public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

        public String getRegisteredBy() {
        return registeredBy;
    }

        public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }
}
