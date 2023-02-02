package com.certant.Consultorio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Laboratorio;

@Repository("laboratorioRepository")
public interface ILaboratorioRepository extends CrudRepository<Laboratorio, Long> {

}
