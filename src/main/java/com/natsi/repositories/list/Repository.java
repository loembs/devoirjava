package com.natsi.repositories.list;
import java.util.List;
public interface Repository<T> {
    boolean insert(T data );
    List<T> selectAll();
}
