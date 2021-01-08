package com.cine.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cine.dto.FiltroVentaDTO;
import com.cine.dto.VentaListaFuncionDTO;
import com.cine.dto.VentaResumenDTO;
import com.cine.model.Venta;
import com.cine.repo.IVentaFuncionRepo;
import com.cine.repo.IVentaRepo;
import com.cine.service.IVentaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo repo;

	@Autowired
	private IVentaFuncionRepo vfRepo;

	@Override
	public Venta registrar(Venta obj) {
		obj.getDetalleVenta().forEach(det -> {
			det.setVenta(obj);
		});
		return repo.save(obj);
	}

	@Transactional
	@Override
	public Venta registrarTransaccional(VentaListaFuncionDTO dto) {
		dto.getVenta().getDetalleVenta().forEach(det -> {
			det.setVenta(dto.getVenta());
		});
		repo.save(dto.getVenta());

		dto.getLstfuncion().forEach(fu -> vfRepo.registrar(dto.getVenta().getIdVenta(), fu.getIdFuncion()));

		return dto.getVenta();
	}

	@Override
	public Venta modificar(Venta obj) {
		return repo.save(obj);
	}

	@Override
	public List<Venta> listar() {
		return repo.findAll();
	}

	@Override
	public Venta leerPorId(Integer id) {
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Venta> buscar(FiltroVentaDTO filtro) {
		return repo.buscar(filtro.getCi(), filtro.getNombreCompleto());
	}

	@Override
	public List<Venta> buscarFecha(FiltroVentaDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaVenta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaVenta(), fechaSgte);

	}

	@Override
	public List<VentaResumenDTO> listarResumen() {
		List<VentaResumenDTO> venta = new ArrayList<>();

		repo.listarResumen().forEach(x -> {
			VentaResumenDTO vr = new VentaResumenDTO();
			vr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			vr.setFecha(String.valueOf(x[1]));
			venta.add(vr);
		});
		return venta;
	}

	@Override
	public byte[] generarReporte() {
		byte[] data = null;

		try {
			File file = new ClassPathResource("/reports/venta.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}