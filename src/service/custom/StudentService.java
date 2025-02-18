package service.custom;

import dto.StudentDto;
import service.SuperService;

public interface StudentService extends SuperService {
    public String save(StudentDto studentDto) throws Exception;

    public String updateInfo(String studentId ,StudentDto studentDto) throws Exception;

    public String updatePassword(String studentId, String password) throws Exception;

    public String delete(String id) throws Exception;

    public StudentDto search(String customerId) throws Exception;
}
