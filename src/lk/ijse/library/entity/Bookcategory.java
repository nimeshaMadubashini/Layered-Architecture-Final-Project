package lk.ijse.library.entity;

public class Bookcategory {
    private String categoryId;
    private String type;
    private int qty;

    public Bookcategory() {
    }

    public Bookcategory(String categoryId, String type, int qty) {
        this.categoryId = categoryId;
        this.type = type;
        this.qty = qty;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
