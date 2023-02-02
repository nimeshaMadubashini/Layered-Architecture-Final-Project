package lk.ijse.library.model;

public class ReportModel {

   /* public static boolean save(ReportDTO report) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO report VALUES(?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1,report.getReportNum());
        pstm.setString(2, report.getStartDate());
        StaffDTO staff=StaffModel.searchName(LoginFormController.userName,LoginFormController.passWord);
        if(staff!= null){
            pstm.setString(3,staff.getStaffId());
        }
        int k= pstm.executeUpdate();
        if(k>0){
            return true;
        }
        return false;
    }
    public static String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT reportNum  FROM report ORDER BY reportNum DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateNextID(result.getString(1));
        }
        return generateNextID(result.getString(null));
    }

    private static String generateNextID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("R0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "R0" + id;
        }
        return "001";

    }*/
}
