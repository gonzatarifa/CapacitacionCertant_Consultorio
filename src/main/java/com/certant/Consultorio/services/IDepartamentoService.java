package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Departamento;

public interface IDepartamentoService {
	
	public List<Departamento> getAll();
	public void save(Departamento departamento);
	public Departamento buscar(long id);
	public void eliminar(long id);
	
	
}
