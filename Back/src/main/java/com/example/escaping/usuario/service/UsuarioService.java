package com.example.escaping.usuario.service;

import java.util.List;

import com.example.escaping.usuario.model.UserRequest;

public interface UsuarioService {

	List<String> addUser(UserRequest userData);

}

