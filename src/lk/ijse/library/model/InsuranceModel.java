package lk.ijse.library.model;

public class InsuranceModel {
   /* public static boolean save(InsuranceDTO insurence) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Insurence VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, insurence.getInsurenceId());
        pstm.setString(2,insurence.getInsurenceType());
        pstm.setString(3,insurence.getPayDate());
        pstm.setString(4,insurence.getRenewDate());
        pstm.setDouble(5,insurence.getAnualPayment());
        StaffDTO staff = StaffModel.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(6,staff.getStaffId());
        }

        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;
    }
    public static boolean update(InsuranceDTO insurance) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Insurence SET insurenceType  =?,payDate =?,renewDate =?,anualPayment =? WHERE insurenceId =?";
        return CrudUtill.execute(sql,insurance.getInsurenceType(),insurance.getPayDate(),insurance.getRenewDate(),insurance.getAnualPayment(),insurance.getInsurenceId());
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from Insurence where insurenceId=?";
        return  CrudUtill.execute(sql,id);
    }*/
}
