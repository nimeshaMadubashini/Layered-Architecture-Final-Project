package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageOtherExpenditureBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.ExpenditureDAO;
import lk.ijse.library.dto.ExpenditureDTO;
import lk.ijse.library.entity.Expenditure;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class ManageOtherExpenditureBOImpl implements ManageOtherExpenditureBO {
     ExpenditureDAO expenditureDAO = (ExpenditureDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.EXPENDITURE);

     @Override
     public boolean saveExpenditure(ExpenditureDTO dto) throws SQLException, ClassNotFoundException {
         return expenditureDAO.save(new Expenditure(dto.getExpenditureId(),dto.getDescription(),dto.getAmount(),
                Date.valueOf(dto.getDate()) ,dto.getAddBy()));
     }

     @Override
     public boolean updateExpenditure(ExpenditureDTO dto) throws SQLException, ClassNotFoundException {
         return expenditureDAO.update(new Expenditure(dto.getExpenditureId(),dto.getDescription(),dto.getAmount(),
                 Date.valueOf(dto.getDate()) ,dto.getAddBy()));
     }

     @Override
     public boolean deleteExpenditure(String id) throws SQLException, ClassNotFoundException {
         return expenditureDAO.Delete(id);
     }

     @Override
     public ObservableList<ExpenditureDTO> loadexpenditureData() throws SQLException, ClassNotFoundException {
         ResultSet resultSet = expenditureDAO.loadData();
         ObservableList<ExpenditureDTO> observableList = FXCollections.observableArrayList();
         while (resultSet.next()) {
             ExpenditureDTO expenditure = new ExpenditureDTO();
             expenditure.setExpenditureId(resultSet.getString(1));
             expenditure.setDescription(resultSet.getString(2));
             expenditure.setAmount(resultSet.getDouble(3));
             expenditure.setDate(String.valueOf(resultSet.getString(4)));
             expenditure.setAddBy(resultSet.getString(5));
             observableList.add(expenditure);
         }
         return observableList;
     }
 }