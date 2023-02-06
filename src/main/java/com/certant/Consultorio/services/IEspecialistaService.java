package com.certant.Consultorio.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Especialista;

@Service
public interface IEspecialistaService {
	public List<Especialista> getAll();

	public Especialista buscar(long id);

	public void eliminar(long id);
	
	public void save(Especialista especialista);
	
	public Especialista getByDni(@Param("dni") int dni);
}
