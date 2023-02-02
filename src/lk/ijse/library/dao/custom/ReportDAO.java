package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.ReportDTO;
import lk.ijse.library.entity.Report;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReportDAO  extends CrudDAO<Report> {
    ResultSet laodDataReport()throws SQLException,ClassNotFoundException;
}
