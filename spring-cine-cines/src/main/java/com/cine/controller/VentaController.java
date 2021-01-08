package com.cine.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cine.dto.FiltroVentaDTO;
import com.cine.dto.VentaDTO;
import com.cine.dto.VentaListaFuncionDTO;
import com.cine.dto.VentaResumenDTO;
import com.cine.exception.ModeloNotFoundException;
import com.cine.model.Archivo;
import com.cine.model.Venta;
import com.cine.service.IArchivoService;
import com.cine.service.IVentaService;
import com.cine.service.impl.VentaServiceImpl;
@RestController
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	private IVentaService service;
	
	@Autowired
	private IArchivoService serviceArchivo;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar() {
		List<Venta> lista = service.listar();
		return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id) {
		Venta obj = service.leerPorId(id);
		if (obj.getIdVenta()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
	 @GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<VentaDTO> listarHateos(){
		 List<Venta> ventas = new ArrayList<>();
		 List<VentaDTO> ventasDTO = new ArrayList<>();
		 ventas = service.listar();
		 
		 for(Venta v : ventas) {
			 VentaDTO d = new VentaDTO();
			 d.setIdVenta(v.getIdVenta());
			 d.setEmpleado(v.getEmpleado());
			 d.setCliente(v.getCliente());
			 
			 ControllerLinkBuilder linkTo  = linkTo(methodOn(VentaController.class).listarPorId((v.getIdVenta())));
			 d.add(linkTo.withSelfRel());
			 ventasDTO.add(d);
			 
			 ControllerLinkBuilder linkTo1 = linkTo(methodOn(EmpleadoController.class).listarPorId((v.getEmpleado().getIdEmpleado())));
			 d.add(linkTo.withSelfRel());
			 ventasDTO.add(d);
			 
			 ControllerLinkBuilder linkTo2 = linkTo(methodOn(ClienteController.class).listarPorId((v.getCliente().getIdCliente())));
			 d.add(linkTo.withSelfRel());
			 ventasDTO.add(d);
		 } 
		 return ventasDTO;
	 }
	 @PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody VentaListaFuncionDTO ventaDTO) {
	  	Venta obj = service.registrarTransaccional(ventaDTO);
	  	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
	  	return ResponseEntity.created(location).build();
	  	}
	  	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta) {
			Venta obj = service.modificar(venta);
			return new ResponseEntity<Venta>(obj, HttpStatus.OK);
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
	  Venta obj = service.leerPorId(id);
	  if (obj.getIdVenta() == null) {
		    throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
	  }
	  	service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
  }
	@PostMapping("/buscar")
	public ResponseEntity<List<Venta>> buscar(@RequestBody FiltroVentaDTO filtro) {
		List<Venta> ventas = new ArrayList<>();

		if (filtro != null) {
			if (filtro.getFechaVenta() != null) {
				ventas = service.buscarFecha(filtro);
			} else {
				ventas = service.buscar(filtro);
			}
		}
		return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
	}
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<VentaResumenDTO>> listarResumen() {
		List<VentaResumenDTO> ventas = new ArrayList<>();
		ventas = service.listarResumen();
		return new ResponseEntity<List<VentaResumenDTO>>(ventas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(){
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
  
	@PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException{
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());
		
		rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}
	
}