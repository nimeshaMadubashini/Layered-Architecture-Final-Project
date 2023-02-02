package lk.ijse.library.model;

public class ExpenditureModel {
   /* public static boolean save(ExpenditureDTO expenditure) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO ExpenditureDTO VALUES(?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1,expenditure.getExpenditureId());
        pstm.setString(2,expenditure.getDescription());
        pstm.setDouble(3,expenditure.getAmount());
        pstm.setString(4, expenditure.getDate());
        StaffDTO staff = StaffModel.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(5,staff.getStaffId());
        }
        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;
    }
    public static boolean update(ExpenditureDTO expenditure) throws SQLException, ClassNotFoundException {
        String sql="UPDATE ExpenditureDTO SET description  =?,amount =?,Date=? WHERE expenditureId=?";
        return CrudUtill.execute(sql,expenditure.getDescription(),expenditure.getAmount(),expenditure.getDate(),expenditure.getExpenditureId());
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from ExpenditureDTO where expenditureId=?";
        return  CrudUtill.execute(sql,id);
    }*/
}
