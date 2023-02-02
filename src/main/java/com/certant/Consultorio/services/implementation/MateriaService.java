package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Materia;
import com.certant.Consultorio.repositories.IMateriaRepository;
import com.certant.Consultorio.services.IMateriaService;

@Service("materiaService")
public class MateriaService implements IMateriaService {

	@Autowired
	@Qualifier("materiaRepository")
	private IMateriaRepository materiaRepository;

	@Override
	public List<Materia> getAll() {
		// TODO Auto-generated method stub
		return materiaRepository.findAll();
	}

	@Override
	public Materia buscar(long id) {
		// TODO Auto-generated method stub
		return materiaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		materiaRepository.deleteById(id);
	}

	@Override
	public void save(Materia materia) {
		// TODO Auto-generated method stub
		System.out.println(materia);
		materiaRepository.save(materia);
	}

	@Override
	public List<Materia> getMateriasByCarrera(Long carreraId) {

		return materiaRepository.getMateriasByCarrera(carreraId);
	}

}
