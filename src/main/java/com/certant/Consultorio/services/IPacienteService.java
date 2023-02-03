package com.certant.Consultorio.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Paciente;


@Service
public interface IPacienteService {
	public List<Paciente> getAll();

	public Paciente buscar(long id);

	public void eliminar(long id);
	
	public void save(Paciente paciente);
	
	public Paciente getByEmail(@Param("email") String email);
	
	public Paciente getByDni(@Param("dni") int dni);
}
