package com.example.escaping.buscador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.escaping.data.model.Provincias;

public interface ProvinciaRepository extends JpaRepository<Provincias, Integer> {
//    @Query("SELECT new AlojamientoDTO(h.nombre, h.imagenUrl) FROM Hotel h JOIN h.localidad l WHERE l.provincia.id = :provinciaId")
    // List<AlojamientoDTO> findAlojamientosByProvinciaId(@Param("provinciaId") Long provinciaId);
}