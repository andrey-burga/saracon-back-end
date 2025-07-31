package com.andreyS.saracon.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.Reporte;
import com.andreyS.saracon.models.entity.TipoReporte;
import com.andreyS.saracon.models.service.SaraconServiceIface;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "*")
public class ReportController {

    private final SaraconServiceIface saraconServiceIface;

    public ReportController(SaraconServiceIface saraconServiceIface) {
        this.saraconServiceIface = saraconServiceIface;
    }

    @GetMapping
    public List<Reporte> getAllReportes() {
        return saraconServiceIface.getAllReports();

    }

    @PostMapping
    public ResponseEntity<?> postReport(@RequestBody Reporte reporte) {
        System.out.println(reporte.getTipoReporte());

        Entidad entidad = saraconServiceIface.getEntidadByEmail(reporte.getEntidadReporta().getEmail());
        TipoReporte tipo = saraconServiceIface.getTipoReportById(reporte.getTipoReporte().getIdTipoReporte());

        reporte.setEntidadReporta(entidad);
        reporte.setTipoReporte(tipo);
        saraconServiceIface.postReport(reporte);

        return ResponseEntity.ok().build();
    }

}
