package lk.ijse.library.dto;

public class CategoryDTO {
    private String categoryId;
    private String type;
    private int qty;

    public CategoryDTO() {

    }

    public CategoryDTO(String categoryId, String type, int qty) {
        this.categoryId = categoryId;
        this.type = type;
        this.qty = qty;
    }

    public CategoryDTO(String categoryId, String type) {
        this.categoryId = categoryId;
        this.type = type;
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
