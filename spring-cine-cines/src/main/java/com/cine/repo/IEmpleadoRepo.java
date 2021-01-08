package com.cine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.model.Empleado;

public interface IEmpleadoRepo extends JpaRepository<Empleado, Integer> {

}
