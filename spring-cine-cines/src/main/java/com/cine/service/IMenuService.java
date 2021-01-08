package com.cine.service;

import java.util.List;

import com.cine.model.Menu;

public interface IMenuService extends ICRUD<Menu>{

	List<Menu> listarMenuPorUsuario(String nombre);
}