package com.davida.finalApp.repository;

import com.davida.finalApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
