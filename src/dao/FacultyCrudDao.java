package dao;

public interface FacultyCrudDao<T, ID> extends SuperDao {
    T search(ID userName) throws Exception;
}
