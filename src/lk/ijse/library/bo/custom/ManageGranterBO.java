package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.GranterDTO;

import java.sql.SQLException;

public interface ManageGranterBO extends SuperBO {
    public  boolean updateGranter(GranterDTO granter) throws SQLException, ClassNotFoundException;
    public  boolean DeleteGranter(String id) throws SQLException, ClassNotFoundException;
    public  boolean saveGranter(GranterDTO granter) throws SQLException, ClassNotFoundException,NullPointerException;
    ObservableList<GranterDTO> loadToTabbel() throws SQLException, ClassNotFoundException;
    public  String generateNextGranterId() throws SQLException, ClassNotFoundException;
    }

