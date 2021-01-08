package com.cine.service;

import com.cine.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);

	byte[] leerArchivo(Integer idArchivo);
}