package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.ManageMemberBO;
import lk.ijse.library.bo.custom.ManageSendEmailBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.MemberDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageSendEmailBOImpl implements ManageSendEmailBO {
    MemberDAO memberDAO= (MemberDAO) DAOFactory.getBoFactory().getDo(DAOFactory.DOType.MEMBER);
    @Override
    public ArrayList<String> loadEmailTOSend() throws SQLException, ClassNotFoundException {
        return memberDAO.loadEmail();
    }
}
