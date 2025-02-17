package dao;



public interface StudentCrudDao<T, ID> extends SuperDao{
    boolean save(T t) throws Exception;

    boolean updateInfo(T t) throws Exception;

    boolean updatePassword(T t) throws Exception;

    boolean delete(ID id) throws Exception;

    T search(ID id) throws Exception;
}
