package dao.custom.Impl;

import java.sql.ResultSet;


import dao.CrudUtil;
import dao.custom.StudentDao;
import entity.StudentEntity;


public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO students (studentName, userName, dateOfBirth, contactInfo, studentPassword) VALUES (?,?,?,?,?)",
                t.getStudentName(), t.getUserName(), t.getStudentDOB(), t.getContactInfo(), t.getStudentPassword());
    }

    @Override
    public boolean updateInfo(String studentId ,StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE students SET studentName = ?, userName=?, dateOfBirth=?, contactInfo=? WHERE studentId=?",
                t.getStudentName(), t.getUserName(), t.getStudentDOB(), t.getContactInfo(), studentId);
    }

    @Override
    public boolean updatePassword(String studentId, String password) throws Exception {

        return CrudUtil.executeUpdate("UPDATE students SET studentPassword = ? WHERE studentId=?",
        password, studentId);
    }

    @Override
    public boolean delete(String StudentId) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM students WHERE studentId=?", StudentId);
    }

    @Override
    public StudentEntity search(String userName) throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM students WHERE userName = ?", userName);
        if (rst.next()) {
            return new StudentEntity(rst.getString("studentId"), rst.getString("studentName"),
                    rst.getString("userName"), rst.getString("dateOfBirth"), rst.getString("contactInfo"),
                    rst.getString("studentPassword"));
        }
        return null;
    }

}
