package com.example.escaping.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.escaping.login.model.LoginData;
import com.example.escaping.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("")
	public ResponseEntity<LoginData> login(@RequestBody LoginData loginData) {
		LoginData response = loginService.getLogginData(loginData);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
	}
	
//	el loginOld contenia un responseEntity<Map<String, Object>> para crear subniveles (nested) e introducir estructura
//	-content (contenido[data]), errorMessage(listadoDeErrores), {opcionalSegunPoint}Paginado
//	@PostMapping("/login")
//	public ResponseEntity<LoginData> loginOld(@RequestBody LoginData loginData) {
//		
////		String respuesta = "";
//		LoginData response = new LoginData();
//		
////		Map<String, Object> response = new HashMap<>();
//		
//		if (loginData != null) {
//			response = loginService.getLogginData(loginData);
//			
////			respuesta = "Login exitoso";
//		} else {
//			return (ResponseEntity<LoginData>) ResponseEntity.badRequest();
//		}
//		
////		response.put("message", respuesta);
//		return ResponseEntity.ok(response);
//	}
}
