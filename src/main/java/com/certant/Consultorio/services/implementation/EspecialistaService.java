package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Especialista;
import com.certant.Consultorio.repositories.IEspecialistaRepository;
import com.certant.Consultorio.services.IEspecialistaService;

@Service("especialistaService")
public class EspecialistaService implements IEspecialistaService {

	@Autowired
	@Qualifier("especialistaRepository")
	private IEspecialistaRepository especialistaRepository;
	
	@Override
	public List<Especialista> getAll() {
		return especialistaRepository.findAll();
	}

	@Override
	public Especialista buscar(long id) {
		return especialistaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		especialistaRepository.deleteById(id);
	}

	@Override
	public void save(Especialista especialista) {
		especialistaRepository.save(especialista);
	}

}
