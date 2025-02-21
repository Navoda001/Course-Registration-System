package dao.custom.Impl;

import java.sql.ResultSet;

import dao.CrudUtil;
import dao.custom.AdminDao;
import entity.AdminEntity;

public class AdminDaoImpl implements AdminDao {

    @Override
    public AdminEntity search(String userName) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM admins WHERE userName = ?", userName);
        if (rst.next()) {
            return new AdminEntity(rst.getString("adminId"), rst.getString("adminName"),
                    rst.getString("userName"), rst.getString("facultyId"), rst.getString("department"),
                    rst.getString("contact_info"), rst.getString("adminPassword"));
        }
        return null;
    }
}
