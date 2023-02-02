package lk.ijse.library.model;

public class NewsPaperModel {
   /* public static boolean save(NewsPaperDTO newsPaper) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO NewsPaperDTO VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, newsPaper.getNewsPaperId());
        pstm.setString(2,newsPaper.getTitle());
        pstm.setInt(3,newsPaper.getQty());
        pstm.setString(4,newsPaper.getDate());
        StaffDTO staff = StaffModel.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(5,staff.getStaffId());
        }
        pstm.setString(6,newsPaper.getSupplyBy());
        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;
    }
    public static boolean update(NewsPaperDTO newsPaper) throws SQLException, ClassNotFoundException {
        String sql="UPDATE NewsPaperDTO SET title =?,qty=?,date=?,supplyBy=? WHERE newsPaperId=?";
        return CrudUtill.execute(sql,newsPaper.getTitle(),newsPaper.getQty(),newsPaper.getDate(),newsPaper.getSupplyBy(),newsPaper.getNewsPaperId());
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from NewsPaperDTO where newsPaperId=?";
        return  CrudUtill.execute(sql,id);
    }*/
}
