package com.cine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.model.Cliente;

public interface IClienteRepo  extends JpaRepository<Cliente, Integer>{

}
