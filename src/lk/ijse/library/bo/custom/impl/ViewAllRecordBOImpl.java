package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ViewAllRecordBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.IssueBookDAO;
import lk.ijse.library.dto.IssueBookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllRecordBOImpl implements ViewAllRecordBO {
    IssueBookDAO issueBookDAO= (IssueBookDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.ISSUEBOOK);
    @Override
    public ObservableList<IssueBookDTO> loadDataSearchingDate(String localDate1, String localDate2) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = issueBookDAO.loadTablefindDate(localDate1, localDate2);
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

    @Override
    public ObservableList<IssueBookDTO> loadAllIssueBookDetailToTable() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = issueBookDAO.loadAllIssueBook();
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
