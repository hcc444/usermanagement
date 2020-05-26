package com.user.management.service;

import java.util.List;
import java.util.Set;

import com.user.management.model.Menu;
import com.user.management.model.User;

public interface UserService {
    
    List<User> listUsers();
    List<User> getUsersByRoleName(String name);
    Set<Menu> getUserMenus(Long id);
}