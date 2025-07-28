package com.andreyS.saracon.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreyS.saracon.models.entity.PersonaNatural;

@Repository
public interface PersonaNaturalDAOIface extends JpaRepository<PersonaNatural, Integer> {

}
