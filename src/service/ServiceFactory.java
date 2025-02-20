package service;

import service.custom.impl.AcademicRecordServiceImpl;
import service.custom.impl.AdminServiceImpl;
import service.custom.impl.CoursesServiceImpl;
import service.custom.impl.EnrollmentServiceImpl;
import service.custom.impl.FacultyServiceImpl;
import service.custom.impl.StudentServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case ADMIN:
                return new AdminServiceImpl();
            case STUDENT:
                return new StudentServiceImpl();
            case FACULTY:
                return new FacultyServiceImpl();
            case COURSE:
                return new CoursesServiceImpl();
            case ACADEMICRECORD:
                return new AcademicRecordServiceImpl();
            case ENROLLMENT:
                return new EnrollmentServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        ADMIN, STUDENT, FACULTY, ENROLLMENT, COURSE, ACADEMICRECORD
    }
}
