package lk.ijse.library.model;

public class BookSupplyDetailModel {
    /*
    public static boolean save(BookSupplyDetailsDTO bookSupplyDetails) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO BookSuuplyDetail VALUES(?,?,?,?,?,?,?)";
        return CrudUtill.execute(sql,bookSupplyDetails.getSupplyId(),bookSupplyDetails.getBookId(),
                bookSupplyDetails.getGranterId(), bookSupplyDetails.getSupplyQty(),bookSupplyDetails.getUnitPrice(),
                bookSupplyDetails.getTotal(),bookSupplyDetails.getSupplyDate());
    }

    public static ArrayList<String> loadSupplyId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT supplyId   FROM BookSuuplyDetail";
        ResultSet result = CrudUtill.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static BookSupplyDetailsDTO searchSupplyDetails(String supplyId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM BookSuuplyDetail where supplyId  =?";
        ResultSet resultSet= CrudUtill.execute(sql,supplyId);
        if(resultSet.next()){
            return new BookSupplyDetailsDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    resultSet.getString(7)

            );
        }

        return null;
    }
    public static boolean update(BookSupplyDetailsDTO bookSupplyDetails) throws SQLException, ClassNotFoundException {
        String sql="UPDATE BookSuuplyDetail SET BookId =?,granterId =?,supplyQty =?,unitPrice =?,total =?,supplyDate =? WHERE supplyId  =?";
        return CrudUtill.execute(sql,bookSupplyDetails.getBookId(),
                bookSupplyDetails.getGranterId(), bookSupplyDetails.getSupplyQty(),bookSupplyDetails.getUnitPrice(),
                bookSupplyDetails.getTotal(),bookSupplyDetails.getSupplyDate(),bookSupplyDetails.getSupplyId());
    }
    public static boolean Delete(String id) throws SQLException, ClassNotFoundException {
        String sql="delete from BookSuuplyDetail where supplyId=?";
        return  CrudUtill.execute(sql,id);
    }

    public static String generateNextId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT supplyId  FROM booksuuplydetail ORDER BY supplyId DESC LIMIT 1";
        ResultSet result = CrudUtill.execute(sql);

        if (result.next()) {
            return generateNextID(result.getString(1));
        }
        return generateNextID(result.getString(null));
    }

    private static String generateNextID(String currentIssue) {
        if (currentIssue != null) {
            String[] split = currentIssue.split("S0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "S0" + id;
        }
        return "001";

    }*/
}
