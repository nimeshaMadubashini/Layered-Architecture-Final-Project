package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.BookSupplyDetailBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.BookDAO;
import lk.ijse.library.dao.custom.GranterDAO;
import lk.ijse.library.dao.custom.impl.BookSuplyDetailDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.BookSupplyDetailsDTO;
import lk.ijse.library.dto.GranterDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Booksuuplydetail;
import lk.ijse.library.entity.Granter;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookSupplyDetailBOImpl implements BookSupplyDetailBO {
    BookDAO bookDAO= (BookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.BOOK);
    GranterDAO granterDAO= (GranterDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.GRANTER);
BookSuplyDetailDAOImpl bookSuplyDetailDAO= (BookSuplyDetailDAOImpl) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.BOOKSUPPLYDETAIL);
    public  boolean saveBookSupplyDetail(BookSupplyDetailsDTO bookSupplyDetails) throws SQLException, ClassNotFoundException {
        return bookSuplyDetailDAO.save((new Booksuuplydetail(bookSupplyDetails.getSupplyId(),bookSupplyDetails.getBookId(),
                bookSupplyDetails.getGranterId(),bookSupplyDetails.getSupplyQty(),bookSupplyDetails.getUnitPrice(),bookSupplyDetails.getTotal() , Date.valueOf(bookSupplyDetails.getSupplyDate()))));
    }
    public ArrayList<String> loadBookSupplyDetailIds() throws SQLException, ClassNotFoundException {
return bookSuplyDetailDAO.loadIds();
    }
    public BookSupplyDetailsDTO searchBookSupplyDetail(String supplyId) throws SQLException, ClassNotFoundException {
     Booksuuplydetail ent=    bookSuplyDetailDAO.search(supplyId);
        return new BookSupplyDetailsDTO(ent.getSupplyId(),ent.getBookId(),
                ent.getGranterId(),ent.getSupplyQty(),ent.getUnitPrice(),ent.getTotal(), String.valueOf(ent.getSupplyDate()));
    }
    public  boolean updateBookSupplyDetail(BookSupplyDetailsDTO bookSupplyDetails) throws SQLException, ClassNotFoundException {
  return     bookSuplyDetailDAO.update((new Booksuuplydetail(bookSupplyDetails.getSupplyId(),bookSupplyDetails.getBookId(),
          bookSupplyDetails.getGranterId(),bookSupplyDetails.getSupplyQty(),bookSupplyDetails.getUnitPrice(),bookSupplyDetails.getTotal() , Date.valueOf(bookSupplyDetails.getSupplyDate()))));
    }

    public  String generateNextBookSupplyId() throws SQLException, ClassNotFoundException {
      return bookSuplyDetailDAO.generateNextId();
    }

    @Override
    public boolean DeleteBookSupplyDetail(String id) throws SQLException, ClassNotFoundException {
        return bookSuplyDetailDAO.Delete(id);
    }
    public BookDTO searchBook(String id) throws SQLException, ClassNotFoundException{
        Book enty= bookDAO.search(id);
        return new BookDTO(id,enty.getName(),enty.getAuthor(),enty.getISBN_Number(),enty.getPublisher(),enty.getQtyOnHand(),enty.getShelfNumber(),
                enty.getNumOfPage(),enty.getAddBy());

    }

    public ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException{
        return bookDAO.loadIds();
    }

    @Override
    public ArrayList<String> loadGranterIds() throws SQLException, ClassNotFoundException {
        return granterDAO.loadIds();
    }

    @Override
    public GranterDTO searchGranter(String grId) throws SQLException, ClassNotFoundException , NullPointerException{
        Granter ent= granterDAO.search(grId);
        return new GranterDTO(ent.getGranterId(),ent.getName(),ent.getAddress(),ent.getTelephoneNumber(),ent.getAddBy());

    }
}
