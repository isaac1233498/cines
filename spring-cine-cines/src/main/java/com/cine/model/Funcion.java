package com.cine.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcion")
public class Funcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFuncion;

	@Column(name = "nom_funcion", nullable = false, length = 70)
	private String nom_funcion;

	@Column(name = "tipo_funcion", nullable = false, length = 2)
	private String tipo_funcion;
	
	private LocalDateTime fecha;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Integer idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getNom_funcion() {
		return nom_funcion;
	}

	public void setNom_funcion(String nom_funcion) {
		this.nom_funcion = nom_funcion;
	}

	public String getTipo_funcion() {
		return tipo_funcion;
	}

	public void setTipo_funcion(String tipo_funcion) {
		this.tipo_funcion = tipo_funcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncion == null) ? 0 : idFuncion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcion other = (Funcion) obj;
		if (idFuncion == null) {
			if (other.idFuncion != null)
				return false;
		} else if (!idFuncion.equals(other.idFuncion))
			return false;
		return true;
	}
}