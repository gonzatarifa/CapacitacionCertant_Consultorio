package com.certant.Consultorio.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Carrera;

import java.io.Serializable;

@Repository("carreraRepository")
public interface ICarreraRepository extends JpaRepository<Carrera,Serializable>{

}
