package lk.ijse.library.model;

public class StaffModel {

   /* public static boolean save(StaffDTO staff) throws SQLException, ClassNotFoundException {
String sql="INSERT INTO staff VALUES(?,?,?,?,?,?)";

return CrudUtill.execute(sql,staff.getStaffId(),staff.getName(),staff.getUserName(),staff.getPassword(),staff.getAddress(),staff.getTelephoneNumber());
    }

    public static boolean verify(StaffDTO staff) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM staff WHERE userName=? and  password=?";
       ResultSet resultSet=CrudUtill.execute(sql,staff.getUserName(),staff.getPassword());
       return resultSet.next();
    }


    public static boolean resetPassword(StaffDTO staff) throws SQLException, ClassNotFoundException {
        String sql="UPDATE staff SET password=? WHERE staffId=? and userName =?";
        return CrudUtill.execute(sql,staff.getPassword(),staff.getStaffId(),staff.getUserName());
    }
    public static StaffDTO searchName(String userName,String password) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM staff where userName=? and  password=?";
        ResultSet resultSet= CrudUtill.execute(sql,userName,password);
        if(resultSet.next()){
            return new StaffDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6)
            );
        }
        return null;
    }

    public static String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT staffId   FROM StaffDTO ORDER BY staffId  DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateNexID(result.getString(1));
        }
        return generateNexID(result.getString(null));
    }

    private static String generateNexID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("S00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "S00" + id;
        }
        return "001";

    }*/
}

