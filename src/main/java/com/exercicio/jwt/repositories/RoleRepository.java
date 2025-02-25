package com.exercicio.jwt.repositories;

import com.exercicio.jwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
