package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.BookIssueBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.*;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookIssueBOImpl implements BookIssueBO {
    BookDAO bookDAO= (BookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.BOOK);
    MemberDAO memberDAO= (MemberDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBER);
    IssueBookDAO issueBookDAO= (IssueBookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.ISSUEBOOK);
    MemberFeesDAO memberFeesDAO= (MemberFeesDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBERFEES);
    public  boolean issueBook(IssueBookDTO issueBook) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

            boolean isIssue = issueBookDAO.updateIssueBookDetait(issueBook.getIssueId(),issueBook.getBookId(), issueBook.getMemberId(),issueBook.getIssueDate(), issueBook.getDueDate(),"pending");
            if (isIssue) {
                boolean updated = bookDAO.updateQty(issueBook.getBookId());
                if (updated) {
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

    public  String generateNextId() throws SQLException, ClassNotFoundException{
        return issueBookDAO.generateNextId();
    }

    @Override

    public BookDTO bookSearch(String id) throws SQLException, ClassNotFoundException{
        Book enty= bookDAO.searchid(id);
        return new BookDTO(enty.getBookId(),enty.getName(),enty.getAuthor()
                ,enty.getQtyOnHand());

    }

    public ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException{
        return bookDAO.loadIds();
    }
    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException{
        Member enty= memberDAO.search(id);
        return new  MemberDTO(enty.getMemberId(), enty.getName(), enty.getEmail(), enty.getAddress(), enty.getTelephoneNumber(),
                String.valueOf(enty.getRegisterDate()) , enty.getRegisteredBy() );
    }
    public  ArrayList<String> loadMemberIds() throws SQLException, ClassNotFoundException{
        return memberDAO.loadIds();
    }
    public  boolean checkMemberPayment( String memId) throws SQLException, ClassNotFoundException{
        return memberFeesDAO.checkPayment(memId);

    }
}
