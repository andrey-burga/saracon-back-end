package com.andreyS.saracon.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.andreyS.saracon.models.request.LoginRequest;
import com.andreyS.saracon.models.service.AuthServiceIface;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    private final AuthServiceIface authServiceIface;

    public LoginController(AuthServiceIface authServiceIface) {
        this.authServiceIface = authServiceIface;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        boolean authenticated = authServiceIface.authenticateUser(
                loginRequest.getEmail(),
                loginRequest.getPassword());

        System.out.println("noseeee: " + authenticated);
        System.out.println("ema: " + loginRequest.getEmail());
        System.out.println("pass: " + loginRequest.getPassword());

        Map<String, String> response = new HashMap<>();

        if (authenticated) {
            response.put("message", "Login exitoso");
            return ResponseEntity.ok().body(response);
        } else {
            response.put("message", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
