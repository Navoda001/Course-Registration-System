package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.EnrollmentDao;
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
    public int search(String coursesId) throws Exception {
        return enrollmentDao.search(coursesId);
    }

    @Override
    public ArrayList<EnrollmentsDto> getAll(String StudentID) throws Exception {
        ArrayList<EnrollmentsDto> enrollmentsDtos = new ArrayList<>();
        ArrayList<EnrollmentsEntity> enrollmentsEntities = enrollmentDao.getAll(StudentID);
        for (EnrollmentsEntity enrollmentsEntity : enrollmentsEntities) {
            EnrollmentsDto dto = new EnrollmentsDto(enrollmentsEntity.getCourseId(),enrollmentsEntity.getSemester(),enrollmentsEntity.getAcademicYear(),enrollmentsEntity.getEnrollmentDate());
            enrollmentsDtos.add(dto);
    }
    return enrollmentsDtos;
 }

}
