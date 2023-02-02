package lk.ijse.library.entity;

public class Granter {
    private  String granterId;
    private  String name;
    private  String address;
    private int telephoneNumber;
    private  String addBy;

    public String getGranterId() {
        return granterId;
    }

    public void setGranterId(String granterId) {
        this.granterId = granterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }

    public Granter() {
    }

    public Granter(String granterId, String name, String address, int telephoneNumber, String addBy) {
        this.granterId = granterId;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.addBy = addBy;
    }

    public Granter(String granterId, String name, String address, int telephoneNumber) {
        this.granterId = granterId;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }


}
