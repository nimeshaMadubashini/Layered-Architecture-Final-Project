package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.IssueBookDTO;
import lk.ijse.library.dto.MemberDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookIssueBO extends SuperBO{

    public  boolean issueBook(IssueBookDTO issueBook) throws SQLException, ClassNotFoundException;

    public  String generateNextId() throws SQLException, ClassNotFoundException;
   public BookDTO bookSearch(String id) throws SQLException, ClassNotFoundException;
 //  public ResultSet bookSearch(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException;
    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException;
    public  ArrayList<String> loadMemberIds() throws SQLException, ClassNotFoundException;

    public  boolean checkMemberPayment( String memId) throws SQLException, ClassNotFoundException;
}
