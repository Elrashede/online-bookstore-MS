package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
