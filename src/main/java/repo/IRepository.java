package repo;

/**
 *
 * @author gera_
 */
public interface IRepository<T> {
    void insert(T entity);
    void delete(T entity);
    void modify(T entity);
    T findById(String id);
}
