package lk.ijse.library.dto;

public class BookDTO {
    private String bookId;
    private String bookName;
    private String author;
    private String isbn ;
    private String publisher;
    private int qtyOnHand;
    private int shelfNo;
    private int  numOfPage;
    private String addBy;
    private String categoryId;

    public BookDTO() {
    }

    public BookDTO(String bookId, String bookName, String author, String isbn, String publisher, int qtyOnHand, int shelfNo, int numOfPage, String categoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.qtyOnHand = qtyOnHand;
        this.shelfNo = shelfNo;
        this.numOfPage = numOfPage;
        this.categoryId = categoryId;
    }

    public BookDTO(String bookId, String bookName, String author, int qtyOnHand) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.qtyOnHand = qtyOnHand;
    }

    public BookDTO(String bookId, String bookName, String author, String isbn, String publisher, int qtyOnHand, int shelfNo, int numOfPage, String addBy, String categoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.qtyOnHand = qtyOnHand;
        this.shelfNo = shelfNo;
        this.numOfPage = numOfPage;
        this.addBy = addBy;
        this.categoryId = categoryId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public int getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(int shelfNo) {
        this.shelfNo = shelfNo;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
