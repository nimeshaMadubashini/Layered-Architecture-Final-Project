package lk.ijse.library.entity;

public class Book {
    private String BookId;
    private  String name;
    private String author;
    private String ISBN_Number;
    private String publisher;
    private int qtyOnHand;
    private int shelfNumber;
    private int numOfPage;
    private String addBy;
    private String bookCategory;

    public Book(String bookId, String name, String author, String ISBN_Number, String publisher, int qtyOnHand, int shelfNumber, int numOfPage, String addBy, String bookCategory) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.ISBN_Number = ISBN_Number;
        this.publisher = publisher;
        this.qtyOnHand = qtyOnHand;
        this.shelfNumber = shelfNumber;
        this.numOfPage = numOfPage;
        this.addBy = addBy;
        this.bookCategory = bookCategory;
    }

    public Book() {
    }

    public Book(String bookId, String name, String author, String ISBN_Number, String publisher, int shelfNumber,
                int numOfPage, String addBy, String bookCategory) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.ISBN_Number = ISBN_Number;
        this.publisher = publisher;
        this.shelfNumber = shelfNumber;
        this.numOfPage = numOfPage;
        this.addBy = addBy;
        this.bookCategory = bookCategory;
    }

    public Book(String bookId, String name, String author, String ISBN_Number, String publisher,
                int shelfNumber, int numOfPage, String bookCategory) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.ISBN_Number = ISBN_Number;
        this.publisher = publisher;
        this.shelfNumber = shelfNumber;
        this.numOfPage = numOfPage;
        this.bookCategory = bookCategory;
    }

    public Book(String bookId, String name, String author, int qtyOnHand) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.qtyOnHand = qtyOnHand;
    }

    public Book(String bookId, String name, String author, String ISBN_Number, String publisher, int qtyOnHand, int shelfNumber, int numOfPage, String bookCategory) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.ISBN_Number = ISBN_Number;
        this.publisher = publisher;
        this.qtyOnHand = qtyOnHand;
        this.shelfNumber = shelfNumber;
        this.numOfPage = numOfPage;
        this.bookCategory = bookCategory;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN_Number() {
        return ISBN_Number;
    }

    public void setISBN_Number(String ISBN_Number) {
        this.ISBN_Number = ISBN_Number;
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

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
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

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}
