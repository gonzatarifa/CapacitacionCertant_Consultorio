package com.certant.Consultorio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPaciente;
	
	@Column(name = "nombre")
	@NotEmpty(message="el campo no debe estar vacio") 
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty(message="el campo no debe estar vacio") 
	private String apellido;
	
	@Column(name="dni")
	@NotNull
	private int dni;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name="observaciones")
	@NotEmpty(message="el campo no debe estar vacio") 
	private String observaciones;
	
}
