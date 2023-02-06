package com.certant.Consultorio.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Especialidad;

@Service
public interface IEspecialidadService {
	public List<Especialidad> getAll();

	public Especialidad buscar(long id);

	public void eliminar(long id);
	
	public void save(Especialidad especialidad);
	
	public Especialidad getByUsername(@Param("nombre") String nombre);
}
