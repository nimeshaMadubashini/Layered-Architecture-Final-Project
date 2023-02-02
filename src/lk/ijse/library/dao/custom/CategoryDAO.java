package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.CategoryDTO;
import lk.ijse.library.entity.Bookcategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CategoryDAO extends CrudDAO<Bookcategory> {
    public ResultSet get() throws SQLException, ClassNotFoundException ;
    public  boolean updateQty(int qtyOnHand, String categoryId) throws SQLException, ClassNotFoundException ;
    public  boolean noupdate(int qtyOnHand, String categoryId) throws SQLException, ClassNotFoundException ;


}
