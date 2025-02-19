package service.custom;

import java.util.ArrayList;

import dto.CoursesDto;
import dto.EnrollmentsDto;
import dto.StudentDto;
import service.SuperService;

public interface EnrollmentService extends SuperService {

    public String save(EnrollmentsDto enrollmentsDto) throws Exception;

    public String Delete(String StudentID , String coursesId) throws Exception;

    public CoursesDto search(String StudentID , String coursesId) throws Exception;

    public ArrayList<EnrollmentsDto> getAll(String StudentID ) throws Exception;
}
