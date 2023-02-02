package lk.ijse.library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.library.dto.ReportDTO;

import java.sql.SQLException;

public interface ManageReportBO extends SuperBO{
    public  boolean saveReport(ReportDTO report) throws SQLException, ClassNotFoundException ;

    public  String generateNextReportId() throws SQLException, ClassNotFoundException;
    ObservableList<ReportDTO> loadReportData() throws SQLException, ClassNotFoundException;

    }
