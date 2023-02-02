package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageInsuranceBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.InsuranceDAO;
import lk.ijse.library.dto.InsuranceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageInsuranceBOImpl implements ManageInsuranceBO {
    InsuranceDAO insuranceDAO = (InsuranceDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.INSURENCE);

    @Override
    public boolean saveInsurance(InsuranceDTO insurence) throws SQLException, ClassNotFoundException {
        return insuranceDAO.save(insurence);
    }

    @Override
    public boolean updateInsurance(InsuranceDTO insurance) throws SQLException, ClassNotFoundException {
        return insuranceDAO.update(insurance);
    }

    @Override
    public boolean DeleteInsurance(String id) throws SQLException, ClassNotFoundException {
        return insuranceDAO.Delete(id);
    }

    @Override
    public ObservableList<InsuranceDTO> LoadAllToInsuranceTable() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = insuranceDAO.loadAllDataToTable();
        ObservableList<InsuranceDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            InsuranceDTO insurance = new InsuranceDTO();
            insurance.setInsurenceId(resultSet.getString(1));
            insurance.setInsurenceType(resultSet.getString(2));
            insurance.setPayDate(resultSet.getString(3));
            insurance.setRenewDate(resultSet.getString(4));
            insurance.setAnualPayment(resultSet.getDouble(5));
            insurance.setAcceptBy(resultSet.getString(6));
            observableList.add(insurance);
        }
        return observableList;
    }
}