package lk.ijse.library.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.library.bo.custom.ManageReportBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.ReportDAO;
import lk.ijse.library.dto.ReportDTO;
import lk.ijse.library.entity.Report;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageReportBOImpl implements ManageReportBO {
ReportDAO reportDAO= (ReportDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.REPORT);
    @Override
    public boolean saveReport(ReportDTO dto) throws SQLException, ClassNotFoundException {
        return reportDAO.save(new Report(dto.getReportNum(), Date.valueOf(dto.getStartDate()),dto.getGetBy()));
    }

    @Override
    public String generateNextReportId() throws SQLException, ClassNotFoundException {
        return reportDAO.generateNextId();
    }

    @Override
    public ObservableList<ReportDTO> loadReportData() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = reportDAO.laodDataReport();
        ObservableList<ReportDTO> observableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            ReportDTO report = new ReportDTO();
            report.setReportNum(resultSet.getString(1));
            report.setStartDate(resultSet.getString(2));
            report.setGetBy(resultSet.getString(3));
            observableList.add(report);
        }
        return observableList ;
    }
}
