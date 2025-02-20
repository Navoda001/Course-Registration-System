package dao.custom.Impl;

import java.sql.ResultSet;

import dao.CrudUtil;
import dao.custom.FacultyDao;
import entity.FacultyEntity;

public class FacultyDaoImpl implements FacultyDao {

    @Override
    public FacultyEntity search(String userName) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM faculties WHERE userName = ?", userName);
        if (rst.next()) {
            return new FacultyEntity(rst.getString("facultyId"), rst.getString("facultyName"),
                    rst.getString("userName"), rst.getString("contactInfo"), rst.getString("facultyPassword"));
        }
        return null;
    }

}
