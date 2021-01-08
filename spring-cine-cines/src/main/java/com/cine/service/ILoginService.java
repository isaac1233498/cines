package com.cine.service;

import com.cine.model.Usuario;

public interface ILoginService {

	Usuario verificarNombreUsuario(String usuario) throws Exception;

	int cambiarClave(String clave, String nombre) throws Exception;
}
