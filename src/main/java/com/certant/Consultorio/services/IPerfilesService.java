package com.certant.Consultorio.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.certant.Consultorio.entities.Perfiles;

@Service
public interface IPerfilesService {
	
	public List<Perfiles> getAll();
	
	public void save(Perfiles perfil);
	
	public Perfiles buscar(long id);
	
	public void eliminar (long id);
	
	public Perfiles getByRol(@Param("rol") String rol);

}
