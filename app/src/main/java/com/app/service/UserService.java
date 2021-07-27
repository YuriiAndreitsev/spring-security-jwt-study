package com.app.service;

import com.app.model.Role;
import com.app.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers(); //usually it is gonna be a Page,
}
