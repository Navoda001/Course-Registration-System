package dao.custom.Impl;

import java.sql.ResultSet;

import dao.CrudUtil;
import dao.custom.StudentDao;
import entity.StudentEntity;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO student (studentName, userName, dateOfBirth, contactInfo, studentPassword) VALUES (?,?,?,?,?)",
                t.getStudentName(), t.getUserName(), t.getStudentDOB(), t.getContactInfo(), t.getStudentPassword());
    }

    @Override
    public boolean updateInfo(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE student SET studentName = ?, userName=?, dateOfBirth=?, contactInfo=? WHERE studentId=?",
                t.getStudentName(), t.getUserName(), t.getStudentDOB(), t.getContactInfo(), t.getStudentId());
    }

    @Override
    public boolean updatePassword(StudentEntity t) throws Exception {

        return CrudUtil.executeUpdate("UPDATE student SET studentPassword = ? WHERE studentId=?",
                t.getStudentPassword(), t.getStudentId());
    }

    @Override
    public boolean delete(String userName) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM student WHERE studentId=?", userName);
    }

    @Override
    public StudentEntity search(String userName) throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student WHERE userName = ?", userName);
        if (rst.next()) {
            return new StudentEntity(rst.getString("studentId"), rst.getString("studentName"),
                    rst.getString("userName"), rst.getString("dateOfBirth"), rst.getString("contactInfo"),
                    rst.getString("studentPassword"));
        }
        return null;
    }

}
