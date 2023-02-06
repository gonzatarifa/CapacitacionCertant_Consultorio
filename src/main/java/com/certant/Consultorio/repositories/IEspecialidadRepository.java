package com.certant.Consultorio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Especialidad;

@Repository("especialidadRepository")
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Serializable> {

	@Query("SELECT e FROM Especialidad e WHERE e.nombre = (:nombre)")
	public abstract Especialidad getByUsername(@Param("nombre") String nombre);
}
