package com.andreyS.saracon.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreyS.saracon.models.entity.TipoReporte;

@Repository
public interface TipoReporteDAOIface extends JpaRepository<TipoReporte, Integer> {

}
