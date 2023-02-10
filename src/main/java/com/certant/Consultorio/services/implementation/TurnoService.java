package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Turno;
import com.certant.Consultorio.repositories.ITurnoRepository;
import com.certant.Consultorio.services.ITurnoService;

@Service("turnoService")
public class TurnoService implements ITurnoService {
	
	@Autowired
	@Qualifier("turnoRepository")
	private ITurnoRepository turnoRepository;
	
	@Override
	public List<Turno> getAll() {
		return turnoRepository.findAll();
	}

	
	@Override
	public List<Turno> getAll(String palabraClave) {
		if(palabraClave != null) {
			return turnoRepository.getAll(palabraClave);
		}
		return turnoRepository.findAll();
	}

	@Override
	public Turno buscar(long id) {
		return turnoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		turnoRepository.deleteById(id);
	}

	@Override
	public void save(Turno turno) {
		turnoRepository.save(turno);
	}

}
