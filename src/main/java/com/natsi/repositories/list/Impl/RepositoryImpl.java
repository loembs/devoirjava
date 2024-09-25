package com.natsi.repositories.list.Impl;

import java.util.ArrayList;
import java.util.List;

import com.natsi.repositories.list.Repository;


public class RepositoryImpl<T> implements Repository<T> {
    protected List<T> list=new ArrayList<>();
    public boolean insert(T data){
        list.add(data);
        return true;
    }
    public List<T> selectAll(){
        return list;
    }
}
