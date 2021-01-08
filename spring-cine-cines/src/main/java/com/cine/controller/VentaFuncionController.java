package com.cine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.model.VentaFuncion;
import com.cine.service.IVentaFuncionService;

@RestController
@RequestMapping("/ventasfuncion")
public class VentaFuncionController {
	
	@Autowired
	private IVentaFuncionService service;
	
	@GetMapping(value = "/{idVenta}")
	public ResponseEntity<List<VentaFuncion>> listar(@PathVariable("idVenta") Integer idventa) {
		List<VentaFuncion> ventasfuncion = new ArrayList<>();
		ventasfuncion = service.listarFuncionPorVenta(idventa);
		return new ResponseEntity<List<VentaFuncion>>(ventasfuncion, HttpStatus.OK);
	}
}
