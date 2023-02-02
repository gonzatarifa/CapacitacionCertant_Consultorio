package com.certant.Consultorio.services;

import java.util.List;

import com.certant.Consultorio.entities.NotaPedido;

public interface INotaPedidoService {
	List<NotaPedido> getAll();

	NotaPedido getById(long id);

	boolean eliminar(long id);

	boolean save(NotaPedido obj);

	NotaPedido aceptarPedido(Long id);

	NotaPedido rechazarPedido(Long id);
}
