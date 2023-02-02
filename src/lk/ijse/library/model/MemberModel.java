package lk.ijse.library.model;

import lk.ijse.library.controller.LoginFormController;

public class MemberModel extends LoginFormController{
   /* public static boolean save(MemberDTO member) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO member VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, member.getMemberId());
        pstm.setString(2,member.getName());
        pstm.setString(3,member.getEmail());
        pstm.setString(4,member.getAddress());
        pstm.setInt(5, member.getTelephoneNumber());
        pstm.setString(6, String.valueOf(member.getRegisterDate()));
        StaffDTO staff = StaffModel.searchName(LoginFormController.userName, LoginFormController.passWord);
        if (staff != null) {
            pstm.setString(7,staff.getStaffId());
        }
        int k=pstm.executeUpdate();
        if(k>0) {
            return true;
        }
        return false;

    }
    public static MemberDTO search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM member WHERE memberId=? ";
        ResultSet resultSet=CrudUtill.execute(sql,id);
        if(resultSet.next()){
            return new MemberDTO(
                    resultSet.getString("memberId"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            resultSet.getString("address"),
            resultSet.getInt("telephoneNumber"),
            resultSet.getString("registerDate"),
            resultSet.getString("registeredBy")
            );
        }
return null;
    }

    public static boolean update(MemberDTO member) throws SQLException, ClassNotFoundException {
String sql="UPDATE member SET name=?,email=?,address=?,telephoneNumber=?,registerDate=? WHERE memberId=?";
return CrudUtill.execute(sql,member.getName(),member.getEmail(),member.getAddress(),member.getTelephoneNumber(),member.getRegisterDate(),member.getMemberId());
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from member where memberId=?";
        return  CrudUtill.execute(sql,id);
    }


    public static ArrayList<String> loadMemIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT memberId  FROM MemberDTO";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
    public static int setData() throws SQLException, ClassNotFoundException {
        String sql="select * from MemberDTO ";
        ResultSet resultSet=CrudUtill.execute(sql);
        resultSet.last();
        return resultSet.getRow();
    }


    public static ArrayList<String> loademail() throws SQLException, ClassNotFoundException {
            String sql = "SELECT email  FROM member";
            ResultSet result = CrudUtill.execute(sql);

            ArrayList<String> idList = new ArrayList<>();

            while (result.next()) {
                idList.add(result.getString(1));
            }
            return idList;
        }*/
}
