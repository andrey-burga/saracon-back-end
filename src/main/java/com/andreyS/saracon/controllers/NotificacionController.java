package com.andreyS.saracon.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.Notificacion;
import com.andreyS.saracon.models.service.SaraconServiceIface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = "*")
public class NotificacionController {

    private final SaraconServiceIface saraconServiceIface;
    LocalDateTime ahora = LocalDateTime.now();

    public NotificacionController(SaraconServiceIface saraconServiceIface) {
        this.saraconServiceIface = saraconServiceIface;
    }

    @GetMapping
    public List<Notificacion> getAllNotification() {

        return saraconServiceIface.getAllNotification(ahora);

    }

    @GetMapping("/old")
    public List<Notificacion> getAllNotificationOld() {

        return saraconServiceIface.getAllNotificationOld(ahora);

    }

    @PostMapping
    public ResponseEntity<?> postNotification(@RequestBody Notificacion notificacion) {

        Entidad entidad = saraconServiceIface.getEntidadByEmail(notificacion.getEntidad().getEmail());

        notificacion.setEntidad(entidad);
        saraconServiceIface.postNotification(notificacion);

        return ResponseEntity.ok().build();
    }

}
