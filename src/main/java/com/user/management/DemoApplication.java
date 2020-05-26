package com.user.management;

import java.util.ArrayList;
import java.util.List;

import com.user.management.model.Menu;
import com.user.management.model.Role;
import com.user.management.model.User;
import com.user.management.repository.MenuRepository;
import com.user.management.repository.RoleRepository;
import com.user.management.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @Profile("!unit")
    CommandLineRunner initDatabase(UserRepository userRepo, RoleRepository roleRepo, MenuRepository menuRepo) {
    return args -> {
        //init MENU
        System.out.println("Preloading " + menuRepo.save(new Menu("Menu1")));
        System.out.println("Preloading " + menuRepo.save(new Menu("Menu2")));
        System.out.println("Preloading " + menuRepo.save(new Menu("Menu3")));

        //init ROLE
        Role role1 = new Role("Role1");
        List<Menu> role1MenuList = new ArrayList<>();
        role1MenuList.add(menuRepo.findByName("Menu1").get());
        //role1MenuList.add(menuRepo.findByName("Menu2").get());
        role1.setMenuList(role1MenuList);
        System.out.println("Preloading " + roleRepo.save(role1));

        Role role2 = new Role("Role2");
        List<Menu> role2MenuList = new ArrayList<>();
        role2MenuList.add(menuRepo.findByName("Menu2").get());
        //role2MenuList.add(menuRepo.findByName("Menu3").get());
        role2.setMenuList(role2MenuList);
        System.out.println("Preloading " + roleRepo.save(role2));

        Role role3 = new Role("Role3");
        List<Menu> role3MenuList = new ArrayList<>();
        role3MenuList.add(menuRepo.findByName("Menu1").get());
        role3MenuList.add(menuRepo.findByName("Menu3").get());
        role3.setMenuList(role3MenuList);
        System.out.println("Preloading " + roleRepo.save(role3));

        //init USER
        User user1 = new User("User1");
        List<Role> user1RoleList = new ArrayList<>();
        user1RoleList.add(roleRepo.findByName("Role1").get());
        user1RoleList.add(roleRepo.findByName("Role2").get());
        user1.setRoleList(user1RoleList);
        System.out.println("Preloading " + userRepo.save(user1));

        User user2 = new User("User2");
        List<Role> user2RoleList = new ArrayList<>();
        user2RoleList.add(roleRepo.findByName("Role2").get());
        user2RoleList.add(roleRepo.findByName("Role3").get());
        user2.setRoleList(user2RoleList);
        System.out.println("Preloading " + userRepo.save(user2));

        User user3 = new User("User3");
        List<Role> user3RoleList = new ArrayList<>();
        user3RoleList.add(roleRepo.findByName("Role1").get());
        user3RoleList.add(roleRepo.findByName("Role3").get());
        user3.setRoleList(user3RoleList);
        System.out.println("Preloading " + userRepo.save(user3));

        
    };
  }

}