package com.cine.dto;

import java.time.LocalDateTime;

public class FiltroVentaDTO {

	private String ci;
	private String nombreCompleto;
	private LocalDateTime fechaVenta;
	
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
}