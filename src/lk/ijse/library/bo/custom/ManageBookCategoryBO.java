package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.CategoryDTO;

import java.sql.SQLException;

public interface ManageBookCategoryBO extends SuperBO {
    public  boolean saveCategory(CategoryDTO category) throws SQLException, ClassNotFoundException;


    public  boolean updateCategory(CategoryDTO category) throws SQLException, ClassNotFoundException;



    public ObservableList<CategoryDTO> loadToTable() throws SQLException, ClassNotFoundException;

    public  boolean DeleteCategory(String id) throws SQLException, ClassNotFoundException;
}
