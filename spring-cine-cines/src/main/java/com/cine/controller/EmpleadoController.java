package com.cine.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cine.exception.ModeloNotFoundException;
import com.cine.model.Empleado;
import com.cine.service.IEmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;
	
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
		@GetMapping
		public ResponseEntity<List<Empleado>> listar() {
			List<Empleado> lista = service.listar();
			return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> listarPorId(@PathVariable("id") Integer id) {
		Empleado emp = service.leerPorId(id);
		if (emp.getIdEmpleado() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Empleado>(emp, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Empleado empleado) {
		Empleado emp = service.registrar(empleado);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empleado.getIdEmpleado()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Empleado> modificar(@Valid @RequestBody Empleado empleado) {
		Empleado emp = service.modificar(empleado);
		return new ResponseEntity<Empleado>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Empleado emp = service.leerPorId(id);
		if (emp.getIdEmpleado() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
