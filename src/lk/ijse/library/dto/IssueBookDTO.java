package lk.ijse.library.dto;

public class IssueBookDTO {
   private String issueId;
   private String BookId ;
   private String  memberId ;
  private String  issueDate ;
 private String   dueDate;
  private String  status ;



    public IssueBookDTO(String issueId, String bookId, String memberId, String issueDate, String dueDate) {
        this.issueId = issueId;
        BookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public IssueBookDTO(String issueId, String bookId, String memberId, String issueDate, String dueDate, String status) {
        this.issueId = issueId;
        BookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public IssueBookDTO() {

    }

    public IssueBookDTO(String bookId, String memberId, String status) {
        BookId = bookId;
        this.memberId = memberId;
        this.status = status;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
