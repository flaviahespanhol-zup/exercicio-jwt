package com.exercicio.jwt.repositories;

import com.exercicio.jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
