package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.BookReturnBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.BookDAO;
import lk.ijse.library.dao.custom.IssueBookDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.entity.Issuebookdetail;

import java.sql.SQLException;

public class BookReturnBOImpl implements BookReturnBO {
    BookDAO bookDAO= (BookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.BOOK);
    IssueBookDAO issueBookDAO= (IssueBookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.ISSUEBOOK);
    public  boolean returnBook(String status2, String status1, String memId, String bookId) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

            boolean isReturn =issueBookDAO.updateReturnBookDetails(status2,status1,memId,bookId);
            if (isReturn) {
                boolean isUpdate = bookDAO.updateAfterReturn(bookId);
                if (isUpdate) {
                    DBConnection.getDbConnection().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getDbConnection().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }

    }
public IssueBookDTO search(String bookId, String memberID, String Status) throws SQLException, ClassNotFoundException {
    Issuebookdetail ent= issueBookDAO.searchIssueBook(bookId,memberID,Status);
    return new IssueBookDTO(ent.getIssueId(),ent.getBookId(),ent.getMemberId(),String.valueOf(ent.getIssueDate()),String.valueOf(ent.getDueDate()),ent.getStatus());
}
    }

