package com.certant.Consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.Departamento;


@Repository("departamentoRepository")
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>{}


