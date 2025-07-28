package com.andreyS.saracon.models.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreyS.saracon.models.entity.Notificacion;

@Repository
public interface NotificacionDAOIface extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findTop10ByFechaVencimientoAfterOrderByFechaNotificacionDesc(LocalDateTime fechaActual);

     List<Notificacion> findTop10ByFechaVencimientoBeforeOrderByFechaNotificacionDesc(LocalDateTime fechaActual);

}
