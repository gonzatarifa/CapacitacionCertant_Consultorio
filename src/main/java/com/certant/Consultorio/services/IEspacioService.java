package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.Espacio;

public interface IEspacioService {

	public List<Espacio> getAll();

	public Espacio save(Espacio espacio);

	public Espacio buscar(long id);

	public void eliminar(long id);
}
