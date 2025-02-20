package dao;

import java.util.ArrayList;

public interface AcademicRecordCrudDao<T, ID> extends SuperDao {
 ArrayList<T> getAll(String studentId) throws Exception;
}
