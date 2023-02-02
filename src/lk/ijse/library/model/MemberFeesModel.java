package lk.ijse.library.model;

public class MemberFeesModel {
   /* public static boolean save(MemberFeesDTO memberFees) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO MemberFeesDTO VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, memberFees.getFeesId());
        pstm.setString(2, memberFees.getMemberId());
        pstm.setString(3, memberFees.getMonth());
        pstm.setDouble(4, memberFees.getAmount());
        pstm.setString(5, memberFees.getAcceptDate());
        StaffDTO staff = StaffModel.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(6, staff.getStaffId());
        }
        int k = pstm.executeUpdate();
        if (k > 0) {
            return true;
        }
        return false;
    }

    public static boolean update(MemberFeesDTO memberFees) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE MemberFeesDTO SET  memberId=?,month=?,amount=?,acceptDate=? WHERE feesId =?";
        return CrudUtill.execute(sql, memberFees.getMemberId(), memberFees.getMonth(), memberFees.getAmount(),
                memberFees.getAcceptDate(), memberFees.getFeesId());
    }

    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "delete from MemberFeesDTO where feesId=?";
        return CrudUtill.execute(sql, id);
    }



    public static boolean checkPayment( String memId) throws SQLException, ClassNotFoundException {
        String Sql="SELECT month FROM MemberFeesDTO WHERE memberId=? ";
        ResultSet resultSet= CrudUtill.execute(Sql,memId);
        return resultSet.next();
    }*/
}

