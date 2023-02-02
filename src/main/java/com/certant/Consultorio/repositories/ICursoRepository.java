package com.certant.Consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certant.Consultorio.entities.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

}
