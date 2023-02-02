package com.certant.Consultorio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Tradicional;

@Repository("tradicionalRepository")
public interface ITradicionalRepository extends CrudRepository<Tradicional, Long> {
	
}
