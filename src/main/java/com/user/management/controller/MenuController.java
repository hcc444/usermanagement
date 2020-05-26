package com.user.management.controller;

import java.util.List;

import com.user.management.model.Menu;
import com.user.management.repository.MenuRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private final MenuRepository repository;

    MenuController(MenuRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/menus")
    public List<Menu> listMenus() {
        return repository.findAll();
    }

}