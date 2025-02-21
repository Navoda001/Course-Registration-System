package dao;

public interface AdminCrudDao<T , ID> extends SuperDao {
    T search(ID userName) throws Exception;
}
