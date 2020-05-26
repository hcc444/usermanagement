package com.user.management.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu implements Comparable<Menu> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "menuList")
    private List<Role> roleList;

    @Override
    public String toString() {
        return String.format("Menu[id=%d, name='%s']", id, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Menu o) {
        return this.name.compareTo(o.name);
    }

}
