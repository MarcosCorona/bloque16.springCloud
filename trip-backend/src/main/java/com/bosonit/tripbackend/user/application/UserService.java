package com.bosonit.tripbackend.user.application;

import com.bosonit.tripbackend.user.domain.Role;
import com.bosonit.tripbackend.user.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();

    User findById(Long id);

}
