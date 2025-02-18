package service.custom;

import dto.StudentDto;
import service.SuperService;

public interface StudentService extends SuperService {
    public String save(StudentDto studentDto) throws Exception;

    public String updateInfo(StudentDto studentDto) throws Exception;

    public String updatePassword(StudentDto studentDto) throws Exception;

    public String delete(String id) throws Exception;

    public StudentDto search(String customerId) throws Exception;
}
