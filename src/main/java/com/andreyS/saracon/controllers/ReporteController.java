package com.andreyS.saracon.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.Report;
import com.andreyS.saracon.models.service.SaraconServiceIface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/report")
public class ReporteController {

    private final SaraconServiceIface saraconServiceIface;

    public ReporteController(SaraconServiceIface saraconServiceIface) {
        this.saraconServiceIface = saraconServiceIface;
    }

    @GetMapping
    public List<Report> getAllNotification() {

        return saraconServiceIface.getAllReports();

    }

    @PostMapping
    public ResponseEntity<?> postNotification(@RequestBody Report reporte) {

        

        Entidad entidad = saraconServiceIface.getEntidadByEmail(reporte.getEntidadReporta().getEmail());

        reporte.setEntidadReporta(entidad);
        saraconServiceIface.postReport(reporte);

        return ResponseEntity.ok().build();
    }

}
