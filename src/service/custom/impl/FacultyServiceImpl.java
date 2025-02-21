package service.custom.impl;

import dao.DaoFactory;
import dao.custom.FacultyDao;
import dto.FacultyDto;
import entity.FacultyEntity;
import service.custom.FacultyService;

public class FacultyServiceImpl implements FacultyService{
    FacultyDao facultyDao = (FacultyDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.FACULTY);
    @Override
    public FacultyDto search(String userName) throws Exception {
        FacultyEntity facultyEntity = facultyDao.search(userName);
        if(facultyEntity != null ){
            FacultyDto dto = new FacultyDto(facultyEntity.getFacultyId(),facultyEntity.getFacultyName(),facultyEntity.getUserName(),facultyEntity.getContactInfo(),facultyEntity.getFacultyPassword());
            return dto;
        }
        return null;
    }

}
