package com.certant.Consultorio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Especialidad;

@Repository("especialidadRepository")
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Serializable> {

}
