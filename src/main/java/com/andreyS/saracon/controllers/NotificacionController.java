package com.andreyS.saracon.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.Notificacion;

import com.andreyS.saracon.models.service.SaraconServiceIface;

@RestController
@RequestMapping("/notification")
public class NotificacionController {

    private final SaraconServiceIface saraconServiceIface;
    LocalDateTime ahora = LocalDateTime.now();

    public NotificacionController(SaraconServiceIface saraconServiceIface) {
        this.saraconServiceIface = saraconServiceIface;
    }

    @GetMapping
    public List<Notificacion> getAllNotificaciones() {
        return saraconServiceIface.getAllNotification(ahora);

    }

    @GetMapping("/old")
    public List<Notificacion> getAllNotificationOld() {

        return saraconServiceIface.getAllNotificationOld(ahora);

    }
 

    @PostMapping
    public ResponseEntity<?> postReport(@RequestBody Notificacion notificacion) {
        System.out.println(notificacion);

        Entidad entidad = saraconServiceIface.getEntidadByEmail(notificacion.getEntidad().getEmail());
        notificacion.setEntidad(entidad);
        saraconServiceIface.postNotification(notificacion);
        
        return ResponseEntity.ok().build();
    }

}
