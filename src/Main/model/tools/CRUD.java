package Main.model.tools;

import java.util.List;

public interface CRUD<T> {
    T save(T t) throws Exception;

    T edit(T t) throws Exception;

    T remove(T t) throws Exception;

    List<T> findAll(T t) throws Exception;

    T findById(int id) throws Exception;
}

