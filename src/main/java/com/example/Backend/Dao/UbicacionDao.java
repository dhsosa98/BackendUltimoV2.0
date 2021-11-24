package com.example.Backend.Dao;

import com.example.Backend.Dominio.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionDao extends JpaRepository<Ubicacion, Long> {
}
