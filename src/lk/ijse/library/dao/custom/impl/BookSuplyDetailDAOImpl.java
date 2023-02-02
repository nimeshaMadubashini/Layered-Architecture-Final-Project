package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.BookSupplyDetailDAO;
import lk.ijse.library.dto.BookSupplyDetailsDTO;
import lk.ijse.library.entity.Booksuuplydetail;
import lk.ijse.library.utill.CrudUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookSuplyDetailDAOImpl implements BookSupplyDetailDAO {

    public  boolean save(Booksuuplydetail bookSupplyDetails) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO BookSuuplyDetail VALUES(?,?,?,?,?,?,?)";
        return CrudUtill.execute(sql,bookSupplyDetails.getSupplyId(),bookSupplyDetails.getBookId(),
                bookSupplyDetails.getGranterId(), bookSupplyDetails.getSupplyQty(),bookSupplyDetails.getUnitPrice(),
                bookSupplyDetails.getTotal(),bookSupplyDetails.getSupplyDate());
    }

    public  ArrayList<String> loadIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT supplyId   FROM BookSuuplyDetail";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    public Booksuuplydetail search(String supplyId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM BookSuuplyDetail where supplyId  =?";
        ResultSet resultSet= CrudUtill.execute(sql,supplyId);
        if(resultSet.next()){
            return new Booksuuplydetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    resultSet.getDate(7)

            );
        }

        return null;
    }
    public  boolean update(Booksuuplydetail bookSupplyDetails) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookSuuplyDetail SET BookId =?,granterId =?,supplyQty =?,unitPrice =?,total =?,supplyDate =? WHERE supplyId  =?";
        return CrudUtill.execute(sql,bookSupplyDetails.getBookId(),
                bookSupplyDetails.getGranterId(), bookSupplyDetails.getSupplyQty(),bookSupplyDetails.getUnitPrice(),
                bookSupplyDetails.getTotal(),bookSupplyDetails.getSupplyDate(),bookSupplyDetails.getSupplyId());
    }
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from BookSuuplyDetail where supplyId=?";
        return  CrudUtill.execute(sql,id);
    }

    public  String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT supplyId  FROM booksuuplydetail ORDER BY supplyId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateID(result.getString(1));
        }
        return generateID(result.getString(null));
    }

    public  String generateID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("S0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "S0" + id;
        }
        return "001";

    }
}
