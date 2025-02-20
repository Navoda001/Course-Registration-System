package dao;

import java.util.ArrayList;

public interface CoursesCrudDao<T, ID> extends SuperDao {
    boolean save(T t) throws Exception;

    boolean update(String id,T t) throws Exception;

    boolean saveAfterEnroll(String courseId,int enrollmentCapacity) throws Exception;

    boolean delete(ID id) throws Exception;

    T search(ID id) throws Exception;

    ArrayList<T> getAll() throws Exception;
}
