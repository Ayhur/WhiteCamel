package com.example.escaping.usuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.escaping.usuario.model.UserRequest;
import com.example.escaping.usuario.repository.UsuarioRepository;
import com.example.escaping.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    @Override
    public List<String> addUser(UserRequest userData) {
        // Directamente guardar el usuario en la base de datos sin comprobar si el DNI ya existe
        usuarioRepository.save(userData);
        
        // Retornar una lista vacía para indicar que no hubo errores
        return new ArrayList<>();
    }
}
