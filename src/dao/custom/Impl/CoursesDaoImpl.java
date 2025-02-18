package dao.custom.Impl;

import java.security.CodeSource;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.CoursesDao;
import entity.CoursesEntity;

public class CoursesDaoImpl implements CoursesDao {

    @Override
    public boolean save(CoursesEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO courses (courseName, creditHours, department, prerequisites, enrollmentCapacity) VALUES (?,?,?,?,?)",
                t.getCourseTitle(), t.getCreditHours(), t.getDepartment(), t.getPrerequisites(),
                t.getEnrollmentCapacity());
    }

    @Override
    public boolean update(CoursesEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE courses SET courseName = ?, creditHours=?, department=?, prerequisites=?,enrollmentCapacity=? WHERE courseId=?",
                t.getCourseTitle(), t.getCreditHours(), t.getDepartment(), t.getPrerequisites(),
                t.getEnrollmentCapacity(), t.getCourseId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM courses WHERE courseId=?", id);
    }

    @Override
    public CoursesEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM courses WHERE courseId = ?", id);
        if (rst.next()) {
            return new CoursesEntity(rst.getString("courseId"), rst.getString("courseName"), rst.getInt("creditHours"),
                    rst.getString("department"), rst.getString("prerequisites"), rst.getInt("enrollmentCapacity"));
        }
        return null;
    }

    @Override
    public ArrayList<CoursesEntity> getAll() throws Exception {
        ArrayList<CoursesEntity> coursesEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM courses");
        while (rst.next()) {            
            coursesEntities.add(new CoursesEntity(rst.getString("courseId"), rst.getString("courseName"),
                    rst.getInt("creditHours"), rst.getString("department"),
                    rst.getString("prerequisites"), rst.getInt("enrollmentCapacity")));
        }
        return coursesEntities;
    }

}
