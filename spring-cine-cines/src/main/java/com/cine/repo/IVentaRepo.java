package com.cine.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cine.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {

	@Query("from Venta v where v.cliente.ci =:ci or LOWER(v.cliente.nom_cliente) like %:nombreCompleto% or LOWER(v.cliente.apell_cliente) like %:nombreCompleto%")
	List<Venta> buscar(@Param("ci") String ci, @Param("nombreCompleto") String nombreCompleto);

	@Query("from Venta v where v.fecha between :buscarVenta and :fechaSgte")
	List<Venta> buscarFecha(@Param("buscarVenta") LocalDateTime fechaVenta,
			@Param("fechaSgte") LocalDateTime fechaSgte);

	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();

}
