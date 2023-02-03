package com.certant.Consultorio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Especialista;

@Service
public interface IEspecialistaService {
	public List<Especialista> getAll();

	public Especialista buscar(long id);

	public void eliminar(long id);
	
	public void save(Especialista especialista);
}
