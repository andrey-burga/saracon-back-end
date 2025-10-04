
package com.andreyS.saracon.models.service;

import java.time.LocalDateTime;
import java.util.List;

import com.andreyS.saracon.models.entity.Empresa;
import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.Notificacion;
import com.andreyS.saracon.models.entity.PersonaNatural;
import com.andreyS.saracon.models.entity.Report;
import com.andreyS.saracon.models.entity.TipoReporte;

public interface SaraconServiceIface {

    List<Notificacion> getAllNotification(LocalDateTime ahora);

    List<Notificacion> getAllNotificationOld(LocalDateTime fechaActual);

    Entidad postEntidad(Entidad entidad);

    void postPersonaNatural(PersonaNatural personaNatural);

    void postEmpresa(Empresa empresa);

    void postReport(Report reporte);

    Entidad getEntidadByEmail(String email);

    TipoReporte getTipoReportById(Integer id);

    List<Report> getAllReports();

    void postNotification(Notificacion notificacion);

}
