package lk.ijse.library.model;

public class CategoryModel {
  /*  public static boolean save(CategoryDTO category) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO BookCategory VALUES(?,?,?)";
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        pstm.setString(1, category.getCategoryId());
        pstm.setString(2, category.getType());
        pstm.setInt(3, 0);

        int k = pstm.executeUpdate();
        if (k > 0) {
            return true;
        }
        return false;

    }

    public static ResultSet get() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM BookCategory";
        ResultSet resultSet = CrudUtill.execute(sql);
        return resultSet;
    }


    public static boolean updateQty(int qtyOnHand, String categoryId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE BookCategory Set qty =qty+? where categoryId=? ";
        return CrudUtill.execute(sql, qtyOnHand, categoryId);
    }
    public static boolean noupdate(int qtyOnHand, String categoryId) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookCategory Set qty =qty-? where categoryId=? ";
        return  CrudUtill.execute(sql,qtyOnHand,categoryId);
}

public static boolean updateCategory(CategoryDTO category) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookCategory set type=? where categoryId=? ";
        return CrudUtill.execute(sql,category.getType(),category.getCategoryId());

}
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from BookCategory where categoryId =?";
        return  CrudUtill.execute(sql,id);
    }

    public static ArrayList<String> loadCatagory() throws SQLException, ClassNotFoundException {
        String sql = "SELECT categoryId    FROM BookCategory";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;

    }*/
}
