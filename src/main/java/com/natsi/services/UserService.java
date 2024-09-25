package com.natsi.services;

import com.natsi.entities.Role;
import com.natsi.entities.User;
import java.util.List;

public interface UserService {
    
    User search(String login);
    List<User> searchrole(Role role);
}
