package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.IssueBookDTO;

import java.sql.SQLException;

public interface BookReturnBO extends SuperBO {
    public  boolean returnBook(String status2, String status1, String memId, String bookId) throws SQLException, ClassNotFoundException;
    public IssueBookDTO search(String bookId, String memberID, String Status) throws SQLException, ClassNotFoundException;
}
