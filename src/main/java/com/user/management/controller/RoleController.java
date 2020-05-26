package com.user.management.controller;

import java.util.List;

import com.user.management.model.Role;
import com.user.management.repository.RoleRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private final RoleRepository repository;

    RoleController(RoleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/roles")
    public List<Role> listRoles() {
        return repository.findAll();
    }

}