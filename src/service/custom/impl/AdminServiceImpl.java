package service.custom.impl;

import dao.DaoFactory;
import dao.custom.AdminDao;
import dto.AdminDto;
import entity.AdminEntity;
import service.custom.AdminService;

public class AdminServiceImpl implements AdminService{

    AdminDao adminDao =  (AdminDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ADMIN);

    @Override
    public AdminDto search(String userName) throws Exception {
         AdminEntity adminEntity = adminDao.search(userName);
        if(adminEntity != null ){
            AdminDto dto = new AdminDto(adminEntity.getAdminId(),adminEntity.getAdminName(),adminEntity.getUserName(),adminEntity.getFacultyId(),adminEntity.getDepartment(),adminEntity.getContactInfo(),adminEntity.getAdminPassword());
            return dto;
        }
        return null;
    }

}
