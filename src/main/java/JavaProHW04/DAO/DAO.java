package JavaProHW04.DAO;

import java.util.List;

public interface DAO<T> extends AutoCloseable {

    void create(T entity);

    List<T> findAll();

    @Override
    void close() throws Exception;
}
