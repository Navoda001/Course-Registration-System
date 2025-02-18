package dao;



public interface StudentCrudDao<T, ID> extends SuperDao{
    boolean save(T t) throws Exception;

    boolean updateInfo(String studentId ,T t) throws Exception;

    boolean updatePassword(String studentUserName, String password) throws Exception;

    boolean delete(ID id) throws Exception;

    T search(ID id) throws Exception;
}
