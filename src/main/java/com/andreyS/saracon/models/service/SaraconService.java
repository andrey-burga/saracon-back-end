package com.andreyS.saracon.models.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.andreyS.saracon.models.dao.*;
import com.andreyS.saracon.models.entity.*;

@Service
public class SaraconService implements SaraconServiceIface {

    private final NotificacionDAOIface notificacionDAOIface;

    private final EntidadDAOIface entidadDAOIface;

    private final PersonaNaturalDAOIface personaNaturalDAOIface;

    private final EmpresaDAOIface empresaDAOIface;

    public SaraconService(NotificacionDAOIface notificacionDAOIface, EmpresaDAOIface empresaDAOIface,
            PersonaNaturalDAOIface personaNaturalDAOIface, EntidadDAOIface entidadDAOIface) {
        this.notificacionDAOIface = notificacionDAOIface;
        this.empresaDAOIface = empresaDAOIface;
        this.entidadDAOIface = entidadDAOIface;
        this.personaNaturalDAOIface = personaNaturalDAOIface;
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

}
