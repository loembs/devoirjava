package com.natsi.repositories;
import java.util.List;
public interface Repository<T> {
    boolean insert(T data );
    List<T> selectAll();
}
