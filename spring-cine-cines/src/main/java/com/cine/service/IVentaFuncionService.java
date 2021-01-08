package com.cine.service;

import java.util.List;

import com.cine.model.VentaFuncion;

public interface IVentaFuncionService {

	List<VentaFuncion> listarFuncionPorVenta(Integer idVenta);
}