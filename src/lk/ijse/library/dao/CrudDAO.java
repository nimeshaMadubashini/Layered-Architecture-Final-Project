package lk.ijse.library.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    public  boolean save(T obj) throws SQLException, ClassNotFoundException;
    public  T search(String id) throws SQLException, ClassNotFoundException;
    public  boolean update(T obj) throws SQLException, ClassNotFoundException ;
    public  boolean Delete(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadIds() throws SQLException, ClassNotFoundException ;
    public String generateNextId() throws SQLException, ClassNotFoundException;
    String generateID(String currentIssue);


}
