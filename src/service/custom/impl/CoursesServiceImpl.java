package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CoursesDao;
import dto.CoursesDto;
import entity.CoursesEntity;
import service.custom.CoursesService;

public class CoursesServiceImpl implements CoursesService {

private CoursesDao coursesDao = (CoursesDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.COURSE);
     

    @Override
    public String save(CoursesDto coursesDto) throws Exception {
       CoursesEntity coursesEntity = new CoursesEntity(coursesDto.getCourseTitle(),coursesDto.getCreditHours(),coursesDto.getDepartment(),coursesDto.getPrerequisites(),coursesDto.getEnrollmentCapacity());
        return coursesDao.save(coursesEntity) ? "Success" : "Fail";
    }

    public String saveAfterEnroll(String CourseId,int enrollmentCapacity  ) throws Exception {
        return coursesDao.saveAfterEnroll(CourseId,enrollmentCapacity) ? "Success" : "Fail";
    }

    @Override
    public String Update( String courseId , CoursesDto coursesDto) throws Exception {
        CoursesEntity coursesEntity = new CoursesEntity(coursesDto.getCourseTitle(),coursesDto.getCreditHours(),coursesDto.getDepartment(),coursesDto.getPrerequisites(),coursesDto.getEnrollmentCapacity());
        return coursesDao.update(courseId,coursesEntity) ? "Success" : "Fail";
    }

    @Override
    public String Delete(String coursesId) throws Exception {
        return coursesDao.delete(coursesId) ? "Success" : "Fail";
    }

    @Override
    public CoursesDto search(String coursesId) throws Exception {
        CoursesEntity coursesEntity = coursesDao.search(coursesId);
        if(coursesEntity != null ){
            CoursesDto dto = new CoursesDto(coursesEntity.getCourseId(),coursesEntity.getCourseTitle(),coursesEntity.getCreditHours(),coursesEntity.getDepartment(),coursesEntity.getPrerequisites(),coursesEntity.getEnrollmentCapacity());
            return dto;
        }
        return null;
    }



    @Override
    public ArrayList<CoursesDto> getAll() throws Exception {
        ArrayList<CoursesDto> customerDtos = new ArrayList<>();
        ArrayList<CoursesEntity> coursesEntitys = coursesDao.getAll();
        for (CoursesEntity coursesEntity : coursesEntitys) {
            CoursesDto dto = new CoursesDto(coursesEntity.getCourseId(),coursesEntity.getCourseTitle());
            customerDtos.add(dto);
    }
    return customerDtos;
}

    

}
