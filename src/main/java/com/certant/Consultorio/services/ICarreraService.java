package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Carrera;

public interface ICarreraService {
	
	public List<Carrera> getAll(); 
	public Carrera buscar(long id);
	public void eliminar(long id);
	public void save(Carrera carrera);
}
