package service.custom.impl;

import dao.DaoFactory;
import dao.custom.StudentDao;
import dto.StudentDto;
import entity.StudentEntity;
import service.custom.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);
    
    @Override
    public StudentDto search(String userName) throws Exception {
        StudentEntity studentEntity = studentDao.search(userName);
        if(studentEntity != null ){
            StudentDto dto = new StudentDto(studentEntity.getStudentId(),studentEntity.getStudentName(),studentEntity.getUserName(),studentEntity.getStudentDOB(),studentEntity.getContactInfo(),studentEntity.getStudentPassword());
            return dto;
        }
        return null;
    }

    @Override
    public String save(StudentDto studentDto) throws Exception {
        StudentEntity studentEntity = new StudentEntity(studentDto.getStudentName(),studentDto.getUserName(),studentDto.getStudentDOB(),studentDto.getContactInfo(),studentDto.getStudentPassword());
        return studentDao.save(studentEntity) ? "Success" : "Fail";
    }

    @Override
    public String updateInfo(StudentDto studentDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInfo'");
    }

    @Override
    public String updatePassword(StudentDto studentDto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");
    }

    @Override
    public String delete(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

   

}
