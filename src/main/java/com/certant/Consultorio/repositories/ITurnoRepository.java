package com.certant.Consultorio.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Turno;

@Repository("turnoRepository")
public interface ITurnoRepository extends JpaRepository<Turno, Serializable> {
	
	@Query("SELECT t FROM Turno t WHERE CONCAT(t.paciente.nombre, ' ', t.paciente.apellido, ' ', t.especialista.nombre, ' ', t.especialista.apellido, ' ',"
			+ "t.especialista.especialidad.nombre, ' ',t.fecha, ' ',t.paciente.dni, ' ',t.especialista.dni) LIKE %?1%")
	public List<Turno> getAll(String palabraClave);
}
