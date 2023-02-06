package com.certant.Consultorio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Especialista;

@Repository("especialistaRepository")
public interface IEspecialistaRepository extends JpaRepository<Especialista, Serializable> {

	@Query("SELECT e FROM Especialista e WHERE e.dni = (:dni)")
	public abstract Especialista getByDni(@Param("dni") int dni);
}
