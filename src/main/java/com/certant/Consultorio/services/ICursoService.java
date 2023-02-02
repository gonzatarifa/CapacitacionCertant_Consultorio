package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Curso;

public interface ICursoService {

	List<Curso> getAll();

	boolean eliminar(long id);

	boolean save(Curso curso);

	Curso getById(long id);
}
