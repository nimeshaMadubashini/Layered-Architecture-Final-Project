package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.InsuranceDTO;

import java.sql.SQLException;

public interface ManageInsuranceBO extends SuperBO {

    public  boolean saveInsurance(InsuranceDTO insurence) throws SQLException, ClassNotFoundException;

    public  boolean updateInsurance(InsuranceDTO insurance) throws SQLException, ClassNotFoundException ;
    public  boolean DeleteInsurance(String id) throws SQLException, ClassNotFoundException;

    ObservableList<InsuranceDTO> LoadAllToInsuranceTable()  throws SQLException, ClassNotFoundException;
}
