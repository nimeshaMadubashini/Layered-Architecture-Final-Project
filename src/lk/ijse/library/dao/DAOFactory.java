package lk.ijse.library.dao;

import lk.ijse.library.dao.custom.ReportDAO;
import lk.ijse.library.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getBoFactory(){
        if(daoFactory==null){
            daoFactory= new DAOFactory();
        }
        return   daoFactory;
    }

    public enum DOType {
        BOOK,BOOKSUPPLYDETAIL,CATEGORY,EXPENDITURE,GRANTER,INSURENCE,ISSUEBOOK,MEMBER,MEMBERFEES,NEWSPAPER,REPORT,STAFF

    }
    public SuperDAO getDo(DAOFactory.DOType doType){
        switch (doType){
            case BOOK:
                return (SuperDAO) new BookDAOImpl();
            case BOOKSUPPLYDETAIL:
                return (SuperDAO) new BookSuplyDetailDAOImpl();
            case CATEGORY:
                return (SuperDAO) new CategoryDAOImpl();
            case EXPENDITURE:
                return (SuperDAO) new ExpenditureDAOImpl();
            case GRANTER:
                return (SuperDAO) new GranterDAOImpl();
            case INSURENCE:
                return (SuperDAO) new InsurenceDAOImpl();
            case MEMBERFEES:
                return (SuperDAO) new MemberFeesDAOImpl();
            case MEMBER:
                return (SuperDAO) new MemberDAOImpl();
            case NEWSPAPER:
                return (SuperDAO) new NewsPaperDAOImpl();
            case REPORT:
                return (SuperDAO) new ReportDAOImpl();
            case STAFF:
                return (SuperDAO) new StaffDAOImpl();
            case ISSUEBOOK:
                return (SuperDAO) new IssueBookDAOImpl();
        }
        return null;
    }
}
