package com.andreyS.saracon.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreyS.saracon.models.entity.Entidad;

@Repository
public interface EntidadDAOIface extends JpaRepository<Entidad, Integer> {

    Entidad findByEmail(String email);

}