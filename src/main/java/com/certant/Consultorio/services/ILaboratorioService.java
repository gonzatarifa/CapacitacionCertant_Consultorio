package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Laboratorio;

public interface ILaboratorioService {
	
	public List<Laboratorio> getAll();

	public Laboratorio buscar(long id);

	public void eliminar(long id);
	
	public void save(Laboratorio laboratorio);
}
