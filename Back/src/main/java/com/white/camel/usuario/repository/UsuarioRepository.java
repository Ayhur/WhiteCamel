package com.white.camel.usuario.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.white.camel.usuario.model.UserRequest;

@Repository
public interface UsuarioRepository extends JpaRepository<UserRequest, String> {
    Optional<UserRequest> findByDni(String dni);
}



