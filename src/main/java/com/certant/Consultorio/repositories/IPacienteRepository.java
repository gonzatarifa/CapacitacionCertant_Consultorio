package com.certant.Consultorio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Paciente;

@Repository("pacienteRepository")
public interface IPacienteRepository extends JpaRepository<Paciente, Serializable> {
	
	@Query("SELECT p FROM Paciente p WHERE p.email = (:email)")
	public abstract Paciente getByEmail(@Param("email") String email);
	
	@Query("SELECT p FROM Paciente p WHERE p.dni = (:dni)")
	public abstract Paciente getByDni(@Param("dni") int dni);

}
