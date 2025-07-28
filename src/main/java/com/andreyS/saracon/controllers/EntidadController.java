package com.andreyS.saracon.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreyS.saracon.models.entity.Empresa;
import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.PersonaNatural;
import com.andreyS.saracon.models.request.RegisterRequest;
import com.andreyS.saracon.models.service.SaraconServiceIface;

@RestController
@RequestMapping("/entidad")
@CrossOrigin(origins = "*")
public class EntidadController {

    private final SaraconServiceIface saraconServiceIface;

    public EntidadController(SaraconServiceIface saraconServiceIface) {
        this.saraconServiceIface = saraconServiceIface;
    }

    @PostMapping("/register")
    public ResponseEntity<?> entidadRegister(@RequestBody RegisterRequest request) {
        boolean algoRegistrado = false;
        if (request.getEntidad() != null) {
            Entidad entidadGuardada = saraconServiceIface.postEntidad(request.getEntidad());
            algoRegistrado = true;

            if (request.getPersonaNatural() != null) {
                PersonaNatural persona = request.getPersonaNatural();
                persona.setEntidad(entidadGuardada); // importante
                saraconServiceIface.postPersonaNatural(persona);
            }

            if (request.getEmpresa() != null) {
                Empresa empresa = request.getEmpresa();
                empresa.setEntidad(entidadGuardada); // importante
                saraconServiceIface.postEmpresa(empresa);
            }
        }

        if (algoRegistrado) {
            return ResponseEntity.ok("Registro exitoso");
        } else {
            return ResponseEntity.badRequest().body("No se encontró información válida para registrar");
        }
    }

}
