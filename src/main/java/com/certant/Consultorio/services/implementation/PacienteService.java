package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Paciente;
import com.certant.Consultorio.repositories.IPacienteRepository;
import com.certant.Consultorio.services.IPacienteService;

@Service("pacienteService")
public class PacienteService implements IPacienteService {
	
	@Autowired
	@Qualifier("pacienteRepository")
	private IPacienteRepository pacienteRepository;
	
	@Override
	public List<Paciente> getAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente buscar(long id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		pacienteRepository.deleteById(id);
	}

	@Override
	public void save(Paciente paciente) {
		pacienteRepository.save(paciente);

	}
	
	@Override
	public Paciente getByEmail(@Param("email") String email) {
		return pacienteRepository.getByEmail(email);
	}

	@Override
	public Paciente getByDni(@Param("dni") int dni) {
		return pacienteRepository.getByDni(dni);
	}

}
