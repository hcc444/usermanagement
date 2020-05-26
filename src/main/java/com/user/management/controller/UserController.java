package com.user.management.controller;

import java.util.List;
import java.util.Set;

import com.user.management.model.Menu;
import com.user.management.model.User;
import com.user.management.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> listUser() {
        return userService.listUsers();
    }
    
    @GetMapping("/users/searchByRole/{name}")
    public List<User> getUsersByRoleName(@PathVariable String name) {
        return userService.getUsersByRoleName(name);
    }
    
    @GetMapping("/users/{id}/menus")
    public Set<Menu> getMenu(@PathVariable Long id) {
        return userService.getUserMenus(id);
    }
    
}