package com.cine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	
	Usuario findOneByUsername(String username);
}
