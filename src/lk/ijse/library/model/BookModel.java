package lk.ijse.library.model;

import lk.ijse.library.controller.LoginFormController;

public class BookModel extends LoginFormController {
    /*public static boolean save(BookDTO book) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);
            String sql = "INSERT INTO BookDTO VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
            pstm.setString(1, book.getBookId());
            pstm.setString(2, book.getBookName());
            pstm.setString(3, book.getAuthor());
            pstm.setString(4, book.getIsbn());
            pstm.setString(5, book.getPublisher());
            pstm.setInt(6, book.getQtyOnHand());
            pstm.setInt(7, book.getShelfNo());
            pstm.setInt(8, book.getNumOfPage());
            StaffDTO staff = StaffModel.searchName(LoginFormController.userName, LoginFormController.passWord);
            if (staff != null) {
                pstm.setString(9, staff.getStaffId());
            }
            pstm.setString(10, book.getCategoryId());
            int k;
            boolean isAdded = pstm.executeUpdate() > 0;
            if (isAdded) {
                boolean updated = CategoryModel.updateQty(book.getQtyOnHand(), book.getCategoryId());
                if (updated) {
                    DBConnection.getDbConnection().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getDbConnection().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }

    }

    public static boolean update(BookDTO book) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE BookDTO SET name=?,author=?,ISBN_Number=?,publisher=?,qtyOnHand=?,shelfNumber =?,numOfPage =?,bookCategory=? where BookId =? ";
        return CrudUtill.execute(sql, book.getBookName(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getQtyOnHand(), book.getShelfNo(), book.getNumOfPage(), book.getCategoryId(), book.getBookId());
    }

    /*public static boolean updateManageBook(BookDTO book) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);

                boolean isUpdate = BookModel.update(new BookDTO(book.getBookId(), book.getBookName(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getQtyOnHand(), book.getShelfNo(), book.getNumOfPage(), book.getCategoryId(), book.getBookId()));
                if (isUpdate) {
                    boolean isCategoryQtyUpdate = CategoryModel.updateQty(book.getQtyOnHand(), book.getCategoryId());
                    if (isCategoryQtyUpdate) {
                        DBConnection.getDbConnection().getConnection().commit();
                        return true;
                    }
                }

            DBConnection.getDbConnection().getConnection().rollback();
            return false;

        } finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }
    }*/
   /* public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from BookDTO where BookId=?";
        return  CrudUtill.execute(sql,id);
    }

    public static ArrayList<String> loadBookIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT BookId   FROM BookDTO";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
    public static BookDTO searchDetail(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM BookDTO where BookId=?";
        ResultSet resultSet= CrudUtill.execute(sql,id);
        if(resultSet.next()){
            return new BookDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8),
                    resultSet.getString(9),
                    resultSet.getString(10)
            );
        }
        return null;
    }
 /*   public static int setData() throws SQLException, ClassNotFoundException {
        String sql="select sum(qtyOnHand)from BookDTO ";
        ResultSet resultSet=CrudUtill.execute(sql);
       // resultSet.last();
        if(resultSet.next()){

        }
    }*/

    /*public static boolean updateQty(String bookId) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookDTO Set qtyOnHand=qtyOnHand-1  where BookId =? ";
        return CrudUtill.execute(sql,bookId);
    }

    public static boolean updateAfterReturn(String bookId) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookDTO Set qtyOnHand=qtyOnHand+1  where BookId =? ";
        return CrudUtill.execute(sql,bookId);
    }
    public static String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT BookId  FROM BookDTO ORDER BY BookId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateNextID(result.getString(1));
        }
        return generateNextID(result.getString(null));
    }

    private static String generateNextID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("B0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "B0" + id;
        }
        return "001";

    }*/
}



