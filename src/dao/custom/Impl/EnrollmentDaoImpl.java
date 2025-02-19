package dao.custom.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.EnrollmentDao;
import dto.EnrollmentsDto;
import entity.EnrollmentsEntity;

public class EnrollmentDaoImpl implements EnrollmentDao{

    @Override
    public boolean save(EnrollmentsEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO enrollments (studentId, courseId, semester, academicYear, enrollmentDate) VALUES (?,?,?,?,?)",
                t.getStudentId(), t.getCourseId(), t.getSemester(), t.getAcademicYear(),
                t.getEnrollmentDate());
    }

   


    @Override
    public boolean Delete(String StudentID, String coursesId) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM enrollments WHERE studentId=? AND courseId=?", StudentID, coursesId);
    }

    @Override
    public EnrollmentsDto search(String StudentID, String coursesId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public ArrayList<EnrollmentsEntity> getAll(String StudentID) throws Exception {
        ArrayList<EnrollmentsEntity> enrollmentsEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM enrollments WHERE studentId=? ",StudentID);
        while (rst.next()) {            
            enrollmentsEntities.add(new EnrollmentsEntity(rst.getString("courseId"),rst.getString("semester"),rst.getString("academicYear"),rst.getString("enrollmentDate")));
        }
        return enrollmentsEntities;
    }

}
