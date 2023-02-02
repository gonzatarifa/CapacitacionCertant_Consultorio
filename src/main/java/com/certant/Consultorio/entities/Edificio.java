package com.certant.Consultorio.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "edificio")
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "edificio_name")
	@NotEmpty
	private String edificio_name;

	@OneToMany(mappedBy = "edificio")
	@JsonIgnore
	// @JoinColumn(name = "aula_id")
	private Set<Aula> aulas;

	public Edificio(@NotEmpty String edificio_name) {
		super();
		this.edificio_name = edificio_name;
	}

}
