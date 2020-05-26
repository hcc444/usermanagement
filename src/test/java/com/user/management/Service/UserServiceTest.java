package com.user.management.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.management.DemoApplication;
import com.user.management.model.User;
import com.user.management.model.Role;
import com.user.management.repository.RoleRepository;
import com.user.management.repository.UserRepository;
import com.user.management.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("unit")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RoleRepository roleRepository;

    @Test
    public void testListUsers() {
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("test1"));
        when(userRepository.findAll()).thenReturn(list);
        List<User> users = userService.listUsers();
        assertEquals(1, users.size());
        assertEquals("test1", users.get(0).getName());
    }

    @Test
    public void testGetUsersByRoleName() {
        Role role = new Role("testRole");
        when(roleRepository.findByName("testRole")).thenReturn(Optional.of(role));
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("test1"));
        when(userRepository.findAllByRoleList(role)).thenReturn(list);
        List<User> users = userService.getUsersByRoleName("testRole");
        assertEquals(1, users.size());
        assertEquals("test1", users.get(0).getName());
    }
}
