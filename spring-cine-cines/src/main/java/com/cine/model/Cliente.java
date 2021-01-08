package com.cine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del cliente")
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;

	@ApiModelProperty(notes = "Nombres debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nom_cliente", nullable = false, length = 70)
	private String nom_cliente;

	@ApiModelProperty(notes = "Apellidos debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "apell_cliente", nullable = false, length = 70)
	private String apell_cliente;

	@ApiModelProperty(notes = "ci debe tener un minimo de 10 caracteres")
	@Size(min = 10, max = 10, message = "ci debe tener un minimo de 10 caracteres")
	@Column(name = "ci", nullable = false, length = 10)
	private String ci;

	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "dir_empleado", nullable = false, length = 70)
	private String dir_empleado;

	@ApiModelProperty(notes = "Telefono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "tlf_empleado", nullable = false, length = 9)
	private Integer tlf_empleado;
	
	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getApell_cliente() {
		return apell_cliente;
	}

	public void setApell_cliente(String apell_cliente) {
		this.apell_cliente = apell_cliente;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getDir_empleado() {
		return dir_empleado;
	}

	public void setDir_empleado(String dir_empleado) {
		this.dir_empleado = dir_empleado;
	}

	public Integer getTlf_empleado() {
		return tlf_empleado;
	}

	public void setTlf_empleado(Integer tlf_empleado) {
		this.tlf_empleado = tlf_empleado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}