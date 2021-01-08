package com.cine.dto;

import java.io.InputStream;
import java.net.URI;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.hateoas.ResourceSupport;

import com.cine.model.Cliente;
import com.cine.model.Empleado;

public class VentaDTO extends ResourceSupport{

	private Integer idVenta;
	private Cliente cliente;
	private Empleado empleado;

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	 
}
