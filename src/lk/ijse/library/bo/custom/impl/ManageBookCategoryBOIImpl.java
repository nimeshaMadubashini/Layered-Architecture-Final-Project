package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageBookCategoryBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.CategoryDAO;
import lk.ijse.library.dto.CategoryDTO;
import lk.ijse.library.entity.Bookcategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageBookCategoryBOIImpl implements ManageBookCategoryBO {

    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.CATEGORY);

    public boolean saveCategory(CategoryDTO category) throws SQLException, ClassNotFoundException {
        return categoryDAO.save(new Bookcategory(category.getCategoryId(),category.getType(),category.getQty()));
    }

    @Override
    public boolean updateCategory(CategoryDTO category) throws SQLException, ClassNotFoundException {
        return categoryDAO.update(new Bookcategory(category.getCategoryId(),category.getType(),category.getQty()));
    }

    @Override
    public ObservableList<CategoryDTO> loadToTable() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = categoryDAO.get();
        ObservableList<CategoryDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            CategoryDTO category = new CategoryDTO();
            category.setCategoryId(resultSet.getString("categoryId"));
            category.setType(resultSet.getString("type"));
            category.setQty(resultSet.getInt("qty"));
            observableList.add(category);
        }
        return observableList;
    }

    @Override
    public boolean DeleteCategory(String id) throws SQLException, ClassNotFoundException {
        return categoryDAO.Delete(id);
    }
}