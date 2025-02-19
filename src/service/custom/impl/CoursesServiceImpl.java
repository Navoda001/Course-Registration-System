package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CoursesDao;
import dto.CoursesDto;
import entity.CoursesEntity;
import entity.StudentEntity;
import service.custom.CoursesService;

public class CoursesServiceImpl implements CoursesService {

private CoursesDao coursesDao = (CoursesDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.COURSE);
     

    @Override
    public String save(CoursesDto coursesDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public String saveAfterEnroll(String CourseId,int enrollmentCapacity  ) throws Exception {
        return coursesDao.saveAfterEnroll(CourseId,enrollmentCapacity) ? "Success" : "Fail";
    }

    @Override
    public String Update(CoursesDto coursesDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public String Delete(String coursesId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
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
