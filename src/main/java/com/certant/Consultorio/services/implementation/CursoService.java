package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certant.Consultorio.entities.Curso;
import com.certant.Consultorio.repositories.ICursoRepository;
import com.certant.Consultorio.services.ICursoService;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private ICursoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Curso getById(long id) {
		Curso curso = null;
		curso = repository.getById(id);
		return curso;
	}

	@Override
	@Transactional
	public boolean eliminar(long id) {
		boolean success = true;
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			success = false;
		}
		return success;

	}

	@Override
	@Transactional
	public boolean save(Curso curso) {
		boolean success = true;
		try {
			repository.save(curso);
		} catch (Exception e) {
			success = true;
		}
		return success;

	}

}
