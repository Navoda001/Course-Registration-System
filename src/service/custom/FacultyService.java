package service.custom;

import dto.FacultyDto;
import service.SuperService;

public interface FacultyService extends SuperService {
    public FacultyDto search(String userName)throws Exception;
}
