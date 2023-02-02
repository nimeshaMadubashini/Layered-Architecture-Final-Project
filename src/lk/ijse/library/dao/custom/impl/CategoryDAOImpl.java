package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.CategoryDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.CategoryDTO;
import lk.ijse.library.entity.Bookcategory;
import lk.ijse.library.utill.CrudUtill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public  boolean save(Bookcategory category) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO BookCategory VALUES(?,?,?)";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, category.getCategoryId());
        pstm.setString(2, category.getType());
        pstm.setInt(3, 0);

        int k = pstm.executeUpdate();
        if (k > 0) {
            return true;
        }
        return false;

    }

    @Override
    public Bookcategory search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public  ResultSet get() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM BookCategory";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }

    @Override
    public  boolean updateQty(int qtyOnHand, String categoryId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE BookCategory Set qty =qty+? where categoryId=? ";
        return CrudUtill.execute(sql, qtyOnHand, categoryId);
    }
    @Override
    public  boolean noupdate(int qtyOnHand, String categoryId) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookCategory Set qty =qty-? where categoryId=? ";
        return  CrudUtill.execute(sql,qtyOnHand,categoryId);
    }
    @Override
    public  boolean update(Bookcategory category) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookCategory set type=? where categoryId=? ";
        return CrudUtill.execute(sql,category.getType(),category.getCategoryId());

    }
    @Override
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from BookCategory where categoryId =?";
        return  CrudUtill.execute(sql,id);
    }
    @Override
    public  ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT categoryId    FROM BookCategory";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;










    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateID(String currentIssue) {
        return null;
    }
}
