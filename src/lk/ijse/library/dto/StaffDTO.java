package lk.ijse.library.dto;

public class StaffDTO {
            private String staffId;
            private String name ;
            private String userName ;
            private String password ;
            private String address   ;
            private int telephoneNumber;

    public StaffDTO() {
    }


    public String toString(String staffid, String confirmpassword) {
        return "StaffDTO{" +
                "staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }

    public StaffDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public StaffDTO(String staffId, String userName, String password) {
        this.staffId = staffId;
        this.userName = userName;
        this.password = password;
    }

    public StaffDTO(String staffId, String name, String userName, String password, String address, int telephoneNumber) {
        this.staffId = staffId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
