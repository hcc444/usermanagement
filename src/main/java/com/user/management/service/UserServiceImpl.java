package com.user.management.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.user.management.model.Menu;
import com.user.management.model.Role;
import com.user.management.model.User;
import com.user.management.repository.RoleRepository;
import com.user.management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRoleName(String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty())
            return null;
        System.out.println("12323"+ role.get().getName());
        return userRepository.findAllByRoleList(role.get());
    }

    @Override
    public Set<Menu> getUserMenus(Long id) {
        TreeSet<Menu> menuSet= new TreeSet<>();
        userRepository.getOne(id).getRoleList().forEach(role -> role.getMenuList().forEach(menu -> menuSet.add(menu)));
        return menuSet;
    }

}