package com.cine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cine.model.VentaFuncion;

public interface IVentaFuncionRepo extends JpaRepository<VentaFuncion, Integer> {

	
	@Modifying
	@Query(value = "INSERT INTO venta_funcion(id_venta, id_funcion) VALUES (:idVenta, :idFuncion)", nativeQuery = true)
	Integer registrar(@Param("idVenta") Integer idVenta, @Param("idFuncion") Integer idFuncion);

	@Query("from VentaFuncion vf where vf.venta.idVenta = :idVenta")
	List<VentaFuncion> listarFuncionPorVenta(@Param("idVenta") Integer idVenta);
}
