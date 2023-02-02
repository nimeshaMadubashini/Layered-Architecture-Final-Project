package lk.ijse.library.bo.custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageSendEmailBO extends SuperBO{
    public ArrayList<String> loadEmailTOSend() throws SQLException, ClassNotFoundException;
}
