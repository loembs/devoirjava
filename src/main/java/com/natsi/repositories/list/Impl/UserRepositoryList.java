package com.natsi.repositories.list.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.natsi.entities.Role;
import com.natsi.entities.User;
import com.natsi.repositories.list.UserRepository;

public class UserRepositoryList extends RepositoryImpl<User> implements UserRepository<User> {
    
    public  User selectByLogin(String login){
        return list.stream()
                .filter(user ->user.getLogin().compareTo(login)==0)
                .findFirst()
                .orElse(null);
    }
    public List<User> selectByRole(Role role) {
        return list.stream()
                .filter(user -> user.getRole().compareTo(role)==0)
                .collect(Collectors.toList());
    }  
}
