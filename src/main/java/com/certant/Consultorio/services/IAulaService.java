package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Aula;
import com.certant.Consultorio.entities.Edificio;
import com.certant.Consultorio.entities.Espacio;

public interface IAulaService {
	List<Aula> getAulasByEdificio(Long id_edificio);

	Aula getAulaById(Long id);
	
	public List<Aula> getAll();
	
	public void save(Aula aula);
	
	public Aula buscar(long id);
	
	public void eliminar (long id);
}
