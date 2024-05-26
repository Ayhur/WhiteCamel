package com.white.camel.usuario.service;

import java.util.List;

import com.white.camel.usuario.model.UserRequest;

public interface UsuarioService {

	List<String> addUser(UserRequest userData);

}

