package com.cine.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.model.Funcion;
import com.cine.repo.IFuncionRepo;
import com.cine.service.IFuncionService;

@Service
public class FuncionServiceImpl implements IFuncionService{

	@Autowired
	private IFuncionRepo repo;

	@Override
	public Funcion registrar(Funcion obj) {
		return repo.save(obj);
	}

	@Override
	public Funcion modificar(Funcion obj) {
		return repo.save(obj);
	}

	@Override
	public List<Funcion> listar() {
		return repo.findAll();
	}

	@Override
	public Funcion leerPorId(Integer id) {
		Optional<Funcion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Funcion();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
