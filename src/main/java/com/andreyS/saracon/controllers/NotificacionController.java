package com.andreyS.saracon.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.andreyS.saracon.models.entity.Notificacion;
import com.andreyS.saracon.models.service.SaraconServiceIface;
import org.springframework.web.bind.annotation.GetMapping;

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

}
