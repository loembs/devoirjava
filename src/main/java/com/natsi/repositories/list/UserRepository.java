package com.natsi.repositories.list;

import com.natsi.entities.Role;
import com.natsi.entities.User;
import java.util.List;

public interface UserRepository<T> extends Repository<User> {
    T selectByLogin(String login);
    List<T> selectByRole(Role role);
}
