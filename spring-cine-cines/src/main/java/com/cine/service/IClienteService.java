package com.cine.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cine.model.Cliente;

public interface IClienteService extends ICRUD<Cliente> {
	
	Page<Cliente> listarPageable(Pageable pageable);
}
