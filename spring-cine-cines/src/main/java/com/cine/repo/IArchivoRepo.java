package com.cine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer>{

}
