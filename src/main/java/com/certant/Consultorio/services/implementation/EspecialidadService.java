package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Especialidad;
import com.certant.Consultorio.repositories.IEspecialidadRepository;
import com.certant.Consultorio.services.IEspecialidadService;

@Service("especialidadService")
public class EspecialidadService implements IEspecialidadService {
	
	@Autowired
	@Qualifier("especialidadRepository")
	private IEspecialidadRepository especialidadRepository;
	
	@Override
	public List<Especialidad> getAll() {
		return especialidadRepository.findAll();
	}

	@Override
	public Especialidad buscar(long id) {
		return especialidadRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		especialidadRepository.deleteById(id);
	}

	@Override
	public void save(Especialidad especialidad) {
		especialidadRepository.save(especialidad);
	}

}
