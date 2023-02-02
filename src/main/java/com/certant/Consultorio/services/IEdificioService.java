package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Edificio;

public interface IEdificioService {
	
	public List<Edificio> getAll();
	
	public void save(Edificio edificio);
	
	public Edificio buscar(long id);
	
	public void eliminar (long id);
}
