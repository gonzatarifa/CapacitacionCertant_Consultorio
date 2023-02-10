package com.certant.Consultorio.entities;

import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name = "turno")
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTurno;
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Ingrese una fecha")
	private LocalDate fecha;
	
	@Column(name = "hora")
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime hora;
	
	@Column(name = "hora_fin")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaFin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idPaciente",nullable=false)
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idEspecialista",nullable=false)
	private Especialista especialista;

	@Column(name ="asistencia")
	private boolean asistencia;
	
}
