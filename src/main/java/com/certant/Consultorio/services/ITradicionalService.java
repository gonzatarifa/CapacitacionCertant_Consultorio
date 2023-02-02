package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Tradicional;

public interface ITradicionalService {
	
	public List<Tradicional> getAll();

	public Tradicional buscar(long id);

	public void eliminar(long id);
	
	public void save(Tradicional tradicional);
}
