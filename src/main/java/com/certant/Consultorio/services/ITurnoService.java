package com.certant.Consultorio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Turno;


@Service
public interface ITurnoService {
	public List<Turno> getAll();

	public Turno buscar(long id);

	public void eliminar(long id);
	
	public void save(Turno turno);
	
}
