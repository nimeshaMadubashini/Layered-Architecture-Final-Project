package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageGranterBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.GranterDAO;
import lk.ijse.library.dto.GranterDTO;
import lk.ijse.library.entity.Granter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageGranterBOImpl implements ManageGranterBO {
    GranterDAO granterDAO= (GranterDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.GRANTER);
    @Override
    public boolean updateGranter(GranterDTO granter) throws SQLException, ClassNotFoundException {
        return granterDAO.update(new Granter(granter.getGranterId(),granter.getName(),granter.getAddress(),granter.getTelephoneNumber(),granter.getAddBy()));

    }

    @Override
    public boolean DeleteGranter(String id) throws SQLException, ClassNotFoundException {
        return granterDAO.Delete(id);
    }

    @Override
    public boolean saveGranter(GranterDTO granter) throws SQLException, ClassNotFoundException {
        return granterDAO.save(new Granter(granter.getGranterId(),granter.getName(),granter.getAddress(),granter.getTelephoneNumber(),granter.getAddBy()));
    }

    @Override
    public ObservableList<GranterDTO> loadToTabbel() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = granterDAO.loadAllToTable();
        ObservableList<GranterDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            GranterDTO granter = new GranterDTO();
            granter.setGranterId(resultSet.getString("granterId"));
            granter.setName(resultSet.getString("name"));
            granter.setAddress(resultSet.getString("address"));
            granter.setTelephoneNumber(resultSet.getInt("telephoneNumber"));
            granter.setAddBy(resultSet.getString("addBy"));
            observableList.add(granter);

        }
        return observableList;
    }
    @Override
    public String generateNextGranterId() throws SQLException, ClassNotFoundException {
        return granterDAO.generateNextId();
    }
}
