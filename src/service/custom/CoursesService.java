package service.custom;

import java.util.ArrayList;

import dto.CoursesDto;
import service.SuperService;

public interface CoursesService extends SuperService{
 public String save(CoursesDto coursesDto)throws Exception;
    public String Update(String courseId,CoursesDto coursesDto)throws Exception;
    public String saveAfterEnroll(String CourseId,int enrollmentCapacity  ) throws Exception;
    public String Delete(String coursesId)throws Exception;
    public CoursesDto search(String coursesId)throws Exception;
    public ArrayList<CoursesDto> getAll()throws Exception;

}
