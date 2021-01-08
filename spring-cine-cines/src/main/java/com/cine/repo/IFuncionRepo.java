package com.cine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.model.Funcion;

public interface IFuncionRepo extends JpaRepository<Funcion, Integer> {

}
