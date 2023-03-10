package com.certant.Consultorio.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name ="especialista")
public class Especialista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEspecialista;
	
	@Column(name = "nombre")
	@NotEmpty(message="el campo no debe estar vacio") 
	private String nombre;

	@Column(name = "apellido")
	@NotEmpty(message="el campo no debe estar vacio") 
	private String apellido;
	
	@Column(name = "dni")
	@NotNull
	private int dni;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idEspecialidad",nullable=false)
	private Especialidad especialidad;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="hora_inicio")
	@NotNull
	private LocalTime horaInicio;
	
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name="hora_fin")
	@NotNull
	private LocalTime horaFin;
	

}
