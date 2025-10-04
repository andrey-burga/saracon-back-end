package com.andreyS.saracon.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.andreyS.saracon.models.request.LoginRequest;
import com.andreyS.saracon.models.results.AuthResult;
import com.andreyS.saracon.models.service.AuthServiceIface;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthServiceIface authServiceIface;

    public LoginController(AuthServiceIface authServiceIface) {
        this.authServiceIface = authServiceIface;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        AuthResult authenticated = authServiceIface.authenticateUser(
                loginRequest.getEmail(),
                loginRequest.getPassword());

        Map<String, String> response = new HashMap<>();

        if (authenticated.isAuthenticated()) {
            response.put("message", "Login exitoso");
            response.put("tipoUsuario", authenticated.getUserType());
            return ResponseEntity.ok().body(response);
        } else {
            response.put("message", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
