package com.example.Backend.Dao;

import com.example.Backend.Dominio.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropietarioDao extends JpaRepository<Propietario, Long> {
}
