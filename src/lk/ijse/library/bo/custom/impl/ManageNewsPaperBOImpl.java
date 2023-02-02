package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageNewsPaperBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.GranterDAO;
import lk.ijse.library.dao.custom.NewsPaperDAO;
import lk.ijse.library.dto.NewsPaperDTO;
import lk.ijse.library.entity.Newspaper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageNewsPaperBOImpl implements ManageNewsPaperBO {
    GranterDAO granterDAO = (GranterDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.GRANTER);
    NewsPaperDAO newsPaperDAO = (NewsPaperDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.NEWSPAPER);

    public ArrayList<String> loadGranterIds() throws SQLException, ClassNotFoundException {
        return granterDAO.loadIds();
    }

    @Override
    public ObservableList<NewsPaperDTO> loadNewsPaperToTable() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = newsPaperDAO.loadnewspaper();
        ObservableList<NewsPaperDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            NewsPaperDTO newsPaper = new NewsPaperDTO();
            newsPaper.setNewsPaperId(resultSet.getString(1));
            newsPaper.setTitle(resultSet.getString(2));
            newsPaper.setQty(resultSet.getInt(3));
            newsPaper.setDate(String.valueOf(resultSet.getString(4)));
            newsPaper.setAcceptBy(resultSet.getString(5));
            newsPaper.setSupplyBy(resultSet.getString(6));
            observableList.add(newsPaper);
        }
        return observableList;
    }

    @Override
    public boolean saveNewsPaper(NewsPaperDTO newsPaper) throws SQLException, ClassNotFoundException {
        return newsPaperDAO.save(new Newspaper(newsPaper.getNewsPaperId(),newsPaper.getTitle(),newsPaper.getQty(),
               Date.valueOf(newsPaper.getDate()) ,newsPaper.getAcceptBy(),newsPaper.getSupplyBy()));
    }

    @Override
    public boolean updateNewsPaper(NewsPaperDTO newsPaper) throws SQLException, ClassNotFoundException {
        return newsPaperDAO.update(new Newspaper(newsPaper.getNewsPaperId(),newsPaper.getTitle(),newsPaper.getQty(),
                Date.valueOf(newsPaper.getDate()) ,newsPaper.getAcceptBy(),newsPaper.getSupplyBy()));
    }

    @Override
    public boolean DeleteNewsPaper(String id) throws SQLException, ClassNotFoundException {
        return newsPaperDAO.Delete(id);
    }
}