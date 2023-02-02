package lk.ijse.library.bo;

import lk.ijse.library.bo.custom.SuperBO;
import lk.ijse.library.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory= new BOFactory();
        }
        return boFactory;
    }

    public enum BOType {
        ADMIN1,ADMINLOGIN1,BOOKSUPPLYDETAIL1,CATEGORY1,EXPENDITURE1,GRANTER1,VEIWDEFAULTLIST1,
        INSURENCE1,ISSUE,RETURN,SEARCH,DASHBOARD1,FINANCIAL1,HOMEPAGE1,LOGIN1,MANAGEBOOK1,VEIWISSUEBOOK1,VEIWALLRECORD1,
        FROGETPASSWORD1,MEMBER1,MEMBERFEES1,NEWSPAPER1,REPORT1,STAFF1,EMAIL1,MEMBERVIEW1,VEIWBOOKSUPPLTDETAIL1

    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case ADMIN1:
                return (SuperBO) new AdminBOImpl();
            case BOOKSUPPLYDETAIL1:
                return (SuperBO) new BookSupplyDetailBOImpl();
            case CATEGORY1:
                return (SuperBO) new ManageBookCategoryBOIImpl();
            case EXPENDITURE1:
                return (SuperBO) new ManageOtherExpenditureBOImpl();
            case GRANTER1:
                return (SuperBO) new ManageGranterBOImpl();
            case INSURENCE1:
                return (SuperBO) new ManageInsuranceBOImpl();
            case MEMBERFEES1:
                return (SuperBO) new ManageMemberFeesBOImpl();
            case MEMBER1:
                return (SuperBO) new ManageMemberBOImpl();
            case NEWSPAPER1:
                return (SuperBO) new ManageNewsPaperBOImpl();
            case REPORT1:
                return (SuperBO) new ManageReportBOImpl();
            case DASHBOARD1:
                return (SuperBO) new DashBoardBOImpl();
            case ISSUE:
                return (SuperBO) new BookIssueBOImpl();
            case RETURN:
                return (SuperBO) new BookReturnBOImpl();
            case MANAGEBOOK1:
                return (SuperBO) new ManageBookBOImpl();
            case VEIWALLRECORD1:
                return (SuperBO) new ViewAllRecordBOImpl();
            case VEIWBOOKSUPPLTDETAIL1:
                return (SuperBO) new VeiwBookSupplyDetailBOImpl();
            case VEIWDEFAULTLIST1:
                return (SuperBO) new ViewDefaulterListBOImpl();
            case VEIWISSUEBOOK1:
                return (SuperBO) new VeiwIssueBookBOImpl();
            case MEMBERVIEW1:
                return (SuperBO) new MemberViewBOImpl();
            case SEARCH:
                return (SuperBO) new BookSearchBoOImpl();
            case HOMEPAGE1:
                return (SuperBO) new HomePageBOImpl();
            case FINANCIAL1:
                return (SuperBO) new FinancialBOImpl();
            case FROGETPASSWORD1:
                return (SuperBO) new FrogetPasswordBOImpl();
            case LOGIN1:
                return (SuperBO) new LoginBOImpl();
            case ADMINLOGIN1:
                return (SuperBO) new AdminLoginBOImpl();
            case EMAIL1:
                return (SuperBO) new ManageSendEmailBOImpl();

        }
        return null;
    }
}
