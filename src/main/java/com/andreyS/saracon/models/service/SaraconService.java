package com.andreyS.saracon.models.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.andreyS.saracon.models.dao.*;
import com.andreyS.saracon.models.entity.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SaraconService implements SaraconServiceIface {

    private final NotificacionDAOIface notificacionDAOIface;

    private final EntidadDAOIface entidadDAOIface;

    private final PersonaNaturalDAOIface personaNaturalDAOIface;

    private final EmpresaDAOIface empresaDAOIface;

    private final ReporteDAOIface reporteDAOIface;

    private final TipoReporteDAOIface tipoReporteDAOIface;

    public SaraconService(NotificacionDAOIface notificacionDAOIface, EmpresaDAOIface empresaDAOIface,
            PersonaNaturalDAOIface personaNaturalDAOIface, EntidadDAOIface entidadDAOIface,
            ReporteDAOIface reporteDAOIface, TipoReporteDAOIface tipoReporteDAOIface) {
        this.notificacionDAOIface = notificacionDAOIface;
        this.empresaDAOIface = empresaDAOIface;
        this.entidadDAOIface = entidadDAOIface;
        this.personaNaturalDAOIface = personaNaturalDAOIface;
        this.reporteDAOIface = reporteDAOIface;
        this.tipoReporteDAOIface = tipoReporteDAOIface;
    }

    @Override
    public List<Notificacion> getAllNotification(LocalDateTime fechaActual) {
        return notificacionDAOIface.findTop10ByFechaVencimientoAfterOrderByFechaNotificacionDesc(fechaActual);
    }

    @Override
    public List<Notificacion> getAllNotificationOld(LocalDateTime fechaActual) {
        return notificacionDAOIface.findTop10ByFechaVencimientoBeforeOrderByFechaNotificacionDesc(fechaActual);
    }

    @Override
    public Entidad postEntidad(Entidad entidad) {
        return entidadDAOIface.save(entidad);
    }

    @Override
    public void postPersonaNatural(PersonaNatural personaNatural) {
        personaNaturalDAOIface.save(personaNatural);
    }

    @Override
    public void postEmpresa(Empresa empresa) {
        empresaDAOIface.save(empresa);
    }

    @Override
    public void postReport(Report reporte) {
        reporteDAOIface.save(reporte);
    }

    @Override
    public Entidad getEntidadByEmail(String email) {
        return entidadDAOIface.findByEmail(email);

    }

    @Override
    public TipoReporte getTipoReportById(Integer id) {
        return tipoReporteDAOIface.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TipoReporte no encontrado con id " + id));
    }

    @Override
    public List<Report> getAllReports() {
        return reporteDAOIface.findAll();
    }

    @Override
    public void postNotification(Notificacion notificacion) {
        notificacionDAOIface.save(notificacion);
    }
}
