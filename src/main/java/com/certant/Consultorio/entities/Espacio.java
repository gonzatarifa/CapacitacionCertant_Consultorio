package com.certant.Consultorio.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "espacio")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Espacio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha")
	@NotNull
	private LocalDate fecha;

	@Column(name = "turno")
	@NotEmpty
	private String turno;

	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;

	@Column(name = "libre")
	private boolean libre;

	@Override
	public boolean equals(Object obj) {
		Espacio other = (Espacio) obj;
		return (aula.equals(other.aula)) && fecha.equals(other.getFecha())
				&& turno.equalsIgnoreCase(other.getTurno());
	}

}
