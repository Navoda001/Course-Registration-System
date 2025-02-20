package dao.custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.AcademicRecordDao;
import entity.AcademicRecordEntity;

public class AcademicRecordDaoImpl implements AcademicRecordDao {

    @Override
    public ArrayList<AcademicRecordEntity> getAll(String studentId) throws Exception {
        ArrayList<AcademicRecordEntity> academicRecordEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM academic_records WHERE studentId=? ",studentId);
        while (rst.next()) {            
            academicRecordEntities.add(new AcademicRecordEntity(rst.getString("courseId"),rst.getString("semester"),rst.getString("grade")));
        }
        return academicRecordEntities;
    }

}
