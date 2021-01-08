package com.cine.dto;

import java.util.List;

import com.cine.model.Funcion;
import com.cine.model.Venta;

public class VentaListaFuncionDTO {

	private Venta venta;
	private List<Funcion> lstfuncion;

	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<Funcion> getLstfuncion() {
		return lstfuncion;
	}
	public void setLstfuncion(List<Funcion> lstfuncion) {
		this.lstfuncion = lstfuncion;
	}
}