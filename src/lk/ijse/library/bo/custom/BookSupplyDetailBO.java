package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.BookSupplyDetailsDTO;
import lk.ijse.library.dto.GranterDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookSupplyDetailBO extends SuperBO{
    public  boolean saveBookSupplyDetail(BookSupplyDetailsDTO bookSupplyDetails) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadBookSupplyDetailIds() throws SQLException, ClassNotFoundException ;
    public BookSupplyDetailsDTO searchBookSupplyDetail(String supplyId) throws SQLException, ClassNotFoundException;
    public  boolean updateBookSupplyDetail(BookSupplyDetailsDTO bookSupplyDetails) throws SQLException, ClassNotFoundException;

    public  String generateNextBookSupplyId() throws SQLException, ClassNotFoundException;

    public  boolean DeleteBookSupplyDetail(String id) throws SQLException, ClassNotFoundException;

    public BookDTO searchBook(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException;

    public  ArrayList<String> loadGranterIds() throws SQLException, ClassNotFoundException;


    public GranterDTO searchGranter(String grId) throws SQLException, ClassNotFoundException;
}
