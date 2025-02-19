package dao;

import java.util.ArrayList;

import dto.EnrollmentsDto;
import entity.EnrollmentsEntity;

public interface EnrollmentCrudDao<T, ID> extends SuperDao {
    public boolean save(T t) throws Exception;

    public boolean Delete(String StudentID, String coursesId) throws Exception;

    public EnrollmentsDto search(String StudentID, String coursesId) throws Exception;

    public ArrayList<EnrollmentsEntity> getAll(String StudentID) throws Exception;
}
