package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.entity.Issuebookdetail;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IssueBookDAO extends CrudDAO<Issuebookdetail> {
    public  int setDataDefault() throws SQLException, ClassNotFoundException;
    public int setData() throws SQLException, ClassNotFoundException;
    public boolean updateReturnBookDetails(String status2, String status1, String memId, String bookId) throws SQLException, ClassNotFoundException;
    public boolean updateIssueBookDetait(String issueId, String bookId, String memberId, String issueDate, String dueDate, String pending) throws SQLException, ClassNotFoundException;
    Issuebookdetail searchIssueBook(String bookId, String memberID, String status)throws SQLException, ClassNotFoundException;
    ResultSet loadTablefindDate(String localDate1,String LocalDate2)throws SQLException, ClassNotFoundException;
    ResultSet loadAllIssueBook()throws SQLException, ClassNotFoundException;

    ResultSet loadAllDefaultList(String todayDate)throws SQLException, ClassNotFoundException;
    ResultSet loadAllPendingList()throws SQLException, ClassNotFoundException;

}
