package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.NewsPaperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageNewsPaperBO extends SuperBO{
    public ArrayList<String> loadGranterIds() throws SQLException, ClassNotFoundException;
    ObservableList<NewsPaperDTO> loadNewsPaperToTable() throws SQLException, ClassNotFoundException;
    public  boolean saveNewsPaper(NewsPaperDTO newsPaper) throws SQLException, ClassNotFoundException;
    public  boolean updateNewsPaper(NewsPaperDTO newsPaper) throws SQLException, ClassNotFoundException ;
    public  boolean DeleteNewsPaper(String id) throws SQLException, ClassNotFoundException;
}
