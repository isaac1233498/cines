package com.cine;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.cine.model.Usuario;
import com.cine.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringCineCinesApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(3);
		us.setUsername("obbakolabi123@hgmail.com");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	} 
}
