package com.certant.Consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certant.Consultorio.entities.NotaPedido;

@Repository
public interface INotaPedidoRepository extends JpaRepository<NotaPedido, Long> {

}
