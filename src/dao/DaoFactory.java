package dao;

import dao.custom.Impl.StudentDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    public DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
            
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoType daoType) {
        switch (daoType) {
            case ADMIN:
                return null;
            case STUDENT:
                return  new StudentDaoImpl();
            case FACULTY:
                return null;
            case COURSE:
                return  null;
            case AcademicRecord:
                return  null;
            case Enrollment:
                return null;    
            default:
                return null;
        }
    }

    public enum DaoType {
        ADMIN, STUDENT, FACULTY, Enrollment, COURSE, AcademicRecord
    }
}
