package com.example.Backend.Dao;

import com.example.Backend.Dominio.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadDao extends JpaRepository<Propiedad, Long> {
}
