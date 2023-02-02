package lk.ijse.library.model;

public class GreanterMadel {

  /*  public static boolean save(GranterDTO granter) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO GranterDTO VALUES(?,?,?,?,?)";
        PreparedStatement pstm= DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, granter.getGranterId());
        pstm.setString(2,granter.getName());
        pstm.setString(3,granter.getAddress());
        pstm.setInt(4, granter.getTelephoneNumber());
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

    public static boolean update(GranterDTO granter) throws SQLException, ClassNotFoundException {
        String sql="UPDATE GranterDTO SET name=?,address=?,telephoneNumber=? WHERE granterId =?";
        return CrudUtill.execute(sql,granter.getName(),granter.getAddress(),granter.getTelephoneNumber(),granter.getGranterId());
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from GranterDTO where granterId=?";
        return  CrudUtill.execute(sql,id);
    }

    public static ArrayList<String> loadGranterId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT granterId  FROM GranterDTO";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }


    public static GranterDTO search(String grId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM GranterDTO where granterId =?";
        ResultSet resultSet= CrudUtill.execute(sql,grId);
        if(resultSet.next()){
            return new GranterDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)

            );
        }

        return null;
    }
    public static String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT granterId  FROM granter ORDER BY granterId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateNextID(result.getString(1));
        }
        return generateNextID(result.getString(null));
    }

    private static String generateNextID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("G00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "G00" + id;
        }
        return "001";

    }*/
}
