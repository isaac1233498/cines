package com.cine.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VentaFuncionPK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "id_Venta", nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "id_funcion", nullable = false)
	private Funcion funcion;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcion == null) ? 0 : funcion.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
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
		VentaFuncionPK other = (VentaFuncionPK) obj;
		if (funcion == null) {
			if (other.funcion != null)
				return false;
		} else if (!funcion.equals(other.funcion))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}
}