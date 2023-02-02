package com.certant.Consultorio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Paciente;

@Repository("pacienteRepository")
public interface IPacienteRepository extends JpaRepository<Paciente, Serializable> {

}
