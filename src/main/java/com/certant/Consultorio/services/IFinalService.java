package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Final;

public interface IFinalService {

	List<Final> getAll();

	Final getById(long id);

	boolean eliminar(long id);

	boolean save(Final obj);
}
