package com.natsi.repositories.core;

import java.util.List;

public interface RepositoryBD<T> {
    boolean insert(T object);
    boolean update(T object);
    boolean delete(int id);
    List<T> selectAll();
    T selectById(int id);
}
