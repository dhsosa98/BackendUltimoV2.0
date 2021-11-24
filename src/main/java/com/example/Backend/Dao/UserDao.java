package com.example.Backend.Dao;

import com.example.Backend.Dominio.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String username);

}
