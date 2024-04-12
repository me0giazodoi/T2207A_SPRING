package com.example.t2207a_springboot.repositories;

import com.example.t2207a_springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
