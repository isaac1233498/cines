package com.cine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cine.dto.FiltroVentaDTO;
import com.cine.dto.VentaListaFuncionDTO;
import com.cine.dto.VentaResumenDTO;
import com.cine.model.Venta;
@Service
public interface IVentaService extends ICRUD<Venta> {

	Venta registrarTransaccional(VentaListaFuncionDTO dto);

	List<Venta> buscar(FiltroVentaDTO filtro);

	List<Venta> buscarFecha(FiltroVentaDTO filtro);

	List<VentaResumenDTO> listarResumen();

	byte[] generarReporte();
}