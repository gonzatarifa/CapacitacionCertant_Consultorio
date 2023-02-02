package com.certant.Consultorio.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data 
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy=InheritanceType.JOINED)  
@Table(name = "aula")
public abstract class Aula{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column(name = "numero")
	@NotNull
	protected int numero;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	protected Edificio edificio;

	
	public boolean comparar(Object obj) {
		Aula other = (Aula) obj;
		return (edificio.getEdificio_name().equalsIgnoreCase(other.getEdificio().getEdificio_name())) && (numero == other.numero);
	}

}
