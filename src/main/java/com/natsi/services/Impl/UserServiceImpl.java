package com.natsi.services.Impl;

import com.natsi.entities.Role;
import com.natsi.entities.User;
import com.natsi.repositories.list.UserRepository;


import java.util.List;

public class UserServiceImpl {

    private UserRepository<User> repository;
    
     public UserServiceImpl(UserRepository<User> repository){
        this.repository = repository;
    }
    
    public void create(User user){
        repository.insert(user);    
    }
    public List<User>findAll(){
        return repository.selectAll();
    }

    public User search(String login){
        return repository.selectByLogin(login);
    }
    public List<User> searchrole(Role role){
        return repository.selectByRole(role);
    }
    
    
}
