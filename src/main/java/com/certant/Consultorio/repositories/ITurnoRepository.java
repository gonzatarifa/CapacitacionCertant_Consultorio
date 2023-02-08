package com.certant.Consultorio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Turno;

@Repository("turnoRepository")
public interface ITurnoRepository extends JpaRepository<Turno, Serializable> {
	
}
