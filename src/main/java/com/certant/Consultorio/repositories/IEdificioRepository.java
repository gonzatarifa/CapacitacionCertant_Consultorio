package com.certant.Consultorio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Edificio;

@Repository("edificioRepository")
public interface IEdificioRepository extends CrudRepository<Edificio, Long> {
	
}
