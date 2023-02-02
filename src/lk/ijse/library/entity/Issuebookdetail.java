package lk.ijse.library.entity;

import rex.utils.S;

import java.sql.Date;

public class Issuebookdetail {
    private String issueId;
    private String BookId;
    private String memberId;
    private Date issueDate;
    private Date dueDate;
    private String status;

    public Issuebookdetail() {
    }

    public Issuebookdetail(String issueId, String bookId, String memberId, Date issueDate, Date dueDate, String status) {
        this.issueId = issueId;
        BookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Issuebookdetail(String bookId, String memberId, String status) {
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
