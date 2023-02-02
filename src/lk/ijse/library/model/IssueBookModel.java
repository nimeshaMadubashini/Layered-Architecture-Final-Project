package lk.ijse.library.model;

public class IssueBookModel {
    /*BookDAOImpl bookDAO=new BookDAOImpl();
    public  boolean issueBook(IssueBookDTO issueBook) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);
            String sql = "INSERT INTO IssueBookDetail VALUES(?,?,?,?,?,?)";
            PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
            pstm.setString(1, issueBook.getIssueId());
            pstm.setString(2, issueBook.getBookId());
            pstm.setString(3, issueBook.getMemberId());
            pstm.setString(4, issueBook.getIssueDate());
            pstm.setString(5, issueBook.getDueDate());
            pstm.setString(6, "pending");
            boolean isIssue = pstm.executeUpdate() > 0;
            if (isIssue) {
                boolean updated = bookDAO.updateQty(issueBook.getBookId());
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

    public  IssueBookDTO search(String bkId, String memId, String status) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM IssueBookDetail where BookId=? and memberId =? and status=?";
        ResultSet resultSet = CrudUtill.execute(sql, bkId, memId, status);
        if (resultSet.next()) {
            return new IssueBookDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;
    }

    public  boolean returnBook(String status2, String status1, String memId, String bookId) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getDbConnection().getConnection().setAutoCommit(false);
            String sql = "UPDATE IssueBookDetail SET status=? WHERE BookId=? and memberId=? and status=? ";
            PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
            pstm.setString(1, status2);
            pstm.setString(2, bookId);
            pstm.setString(3, memId);
            pstm.setString(4, status1);
            boolean isReturn = pstm.executeUpdate() > 0;
            if (isReturn) {
                boolean isUpdate = bookDAO.updateAfterReturn(bookId);
                if (isUpdate) {
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
    public  String generateNextIssueId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT issueId  FROM IssueBookDetail ORDER BY issueId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateNextIssueID(result.getString(1));
        }
        return generateNextIssueID(result.getString(null));
    }

    private  String generateNextIssueID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("SI0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "SI0" + id;
        }
        return "001";

    }


    public int setData() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM IssueBookDetail where status='"+"pending"+"'";
        ResultSet resultSet=CrudUtill.execute(sql);
        resultSet.last();
        return resultSet.getRow();
    }

    public  int setDataDefault() throws SQLException, ClassNotFoundException {
        long dt=System.currentTimeMillis();
        Date todayDate=new Date(dt);
        String sql = "SELECT * FROM IssueBookDetail where dueDate<? and  status='"+"pending"+"'";
        ResultSet resultSet = CrudUtill.execute(sql,todayDate);
        resultSet.last();
        return resultSet.getRow();
    }*/
}
