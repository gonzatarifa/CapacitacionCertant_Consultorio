package com.certant.Consultorio.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certant.Consultorio.entities.NotaPedido;
import com.certant.Consultorio.repositories.INotaPedidoRepository;
import com.certant.Consultorio.services.INotaPedidoService;
import com.certant.Consultorio.util.NotaPedidoStatusEnum;

@Service
public class NotaPedidoService implements INotaPedidoService {

	@Autowired
	private INotaPedidoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<NotaPedido> getAll() {
		return (List<NotaPedido>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public NotaPedido getById(long id) {
		return repository.getById(id);
	}

	@Override
	@Transactional
	public boolean eliminar(long id) {
		boolean success = true;
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean save(NotaPedido obj) {
		boolean success = true;
		System.out.println("NOTA PEDIDO NUEVO");
		System.out.println(obj);
		try {
			repository.save(obj);
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;

	}

	@Override
	public NotaPedido aceptarPedido(Long id) {
		NotaPedido nota = repository.getById(id);
		nota.setStatus(NotaPedidoStatusEnum.ACEPTADO);
		return repository.save(nota);
	}

	@Override
	public NotaPedido rechazarPedido(Long id) {
		NotaPedido nota = repository.getById(id);
		nota.setStatus(NotaPedidoStatusEnum.RECHAZADO);
		return repository.save(nota);
	}

}
