package com.example.Backend.Dao;

import com.example.Backend.Dominio.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByPassword(String password);
}
