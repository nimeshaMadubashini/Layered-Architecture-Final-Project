package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ViewDefaulterListBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.IssueBookDAO;
import lk.ijse.library.dto.IssueBookDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewDefaulterListBOImpl implements ViewDefaulterListBO {
    IssueBookDAO issueBookDAO= (IssueBookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.ISSUEBOOK);
    @Override
    public ObservableList<IssueBookDTO> loadDefaultListToTable(String todayDate) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = issueBookDAO.loadAllDefaultList(todayDate);
        ObservableList<IssueBookDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            IssueBookDTO issueBook = new IssueBookDTO();
            issueBook.setIssueId(resultSet.getString(1));
            issueBook.setBookId(resultSet.getString(2));
            issueBook.setMemberId(resultSet.getString(3));
            issueBook.setIssueDate(String.valueOf(resultSet.getString(4)));
            issueBook.setDueDate(String.valueOf(resultSet.getString(5)));
            issueBook.setStatus(resultSet.getString(6));
            observableList.add(issueBook);

        }
        return observableList;
    }
}
