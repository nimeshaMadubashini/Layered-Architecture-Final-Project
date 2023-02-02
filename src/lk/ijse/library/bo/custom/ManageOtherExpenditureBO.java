package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.ExpenditureDTO;

import java.sql.SQLException;

public interface ManageOtherExpenditureBO  extends SuperBO{
    public boolean saveExpenditure(ExpenditureDTO expenditure) throws SQLException, ClassNotFoundException ;
    public  boolean updateExpenditure(ExpenditureDTO expenditure) throws SQLException, ClassNotFoundException ;
    public  boolean deleteExpenditure(String id) throws SQLException, ClassNotFoundException ;
    ObservableList<ExpenditureDTO> loadexpenditureData()throws SQLException, ClassNotFoundException ;


    }
