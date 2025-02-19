package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.EnrollmentDao;
import dto.CoursesDto;
import dto.EnrollmentsDto;
import entity.EnrollmentsEntity;
import service.custom.EnrollmentService;

public class EnrollmentServiceImpl implements EnrollmentService {

private EnrollmentDao enrollmentDao =  (EnrollmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ENROLLMENT);

    @Override
    public String save(EnrollmentsDto enrollmentsDto) throws Exception {
        EnrollmentsEntity enrollmentsEntity = new EnrollmentsEntity(enrollmentsDto.getStudentId(),enrollmentsDto.getCourseId(),enrollmentsDto.getSemester(),enrollmentsDto.getEnrollmentDate(),enrollmentsDto.getAcademicYear());
        return enrollmentDao.save(enrollmentsEntity) ? "Success" : "Fail";
    }
    

    @Override
    public String Delete(String StudentID, String coursesId) throws Exception {
        return enrollmentDao.Delete(StudentID,coursesId) ? "Success" : "Fail";
    }

    @Override
    public CoursesDto search(String StudentID, String coursesId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public ArrayList<EnrollmentsDto> getAll(String StudentID) throws Exception {
        ArrayList<EnrollmentsDto> enrollmentsDtos = new ArrayList<>();
        ArrayList<EnrollmentsEntity> enrollmentsEntities = enrollmentDao.getAll(StudentID);
        for (EnrollmentsEntity coursesEntity : enrollmentsEntities) {
            EnrollmentsDto dto = new EnrollmentsDto(coursesEntity.getCourseId(),coursesEntity.getSemester(),coursesEntity.getAcademicYear(),coursesEntity.getEnrollmentDate());
            enrollmentsDtos.add(dto);
    }
    return enrollmentsDtos;
 }

}
