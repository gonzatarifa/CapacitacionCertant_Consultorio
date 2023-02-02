package com.certant.Consultorio.models;

import java.time.LocalDateTime;

import com.certant.Consultorio.entities.Espacio;
import com.certant.Consultorio.entities.Materia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class NotaPedidoModel {

	private int id;
	private LocalDateTime fechaInicioPedido;
	private int cantEstudiantes;
	private Espacio espacio;
	private Materia materia;
	private String observaciones;

}
