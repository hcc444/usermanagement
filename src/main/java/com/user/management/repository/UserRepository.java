package com.user.management.repository;

import java.util.List;

import com.user.management.model.Role;
import com.user.management.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByRoleList(Role role);
}
