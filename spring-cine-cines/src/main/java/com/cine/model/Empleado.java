package com.cine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Información del empleado")
@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;

	@ApiModelProperty(notes = "Nombres empleado debe tener minimo 3 caracteres")	
	@Size(min = 3, message = "Nombres empleado debe tener minimo 3 caracteres")
	@Column(name = "nom_empleado", nullable = false, length = 70)
	private String nom_empleado;

	@ApiModelProperty(notes = "Apellido empleado debe tener minimo 3 caracteres")		
	@Size(min = 3, message = "Apellido empleado debe tener minimo 3 caracteres")
	@Column(name = "apell_empleado", nullable = false, length = 70)
	private String apell_empleado;

	@ApiModelProperty(notes = "Cedula de identidad delempleado debe tener un minimo de 10 caracteres")	
	@Size(min = 10, max = 10, message = "Cedula de identidad delempleado debe tener un minimo de 10 caracteres")
	@Column(name = "ci_empleado", nullable = false, length = 10)
	private String ci_empleado;

	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")	
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "dir_empleado", nullable = false, length = 70)
	private String dir_empleado;

	@ApiModelProperty(notes = "Telefono empleado debe tener 9 caracteres")	
	@Size(min = 9, max = 9, message = "Telefono empleado debe tener 9 caracteres")
	@Column(name = "tlf_empleado", nullable = false, length = 9)
	private Integer tlf_empleado;

	@ApiModelProperty(notes = "Cargo empleado debe tener 9 caracteres")	
	@Size(min = 3, max = 15, message = "Cargo empleado debe tener 9 caracteres")
	@Column(name = "cargo", nullable = false, length = 15 )
	private String cargo;

	@ApiModelProperty(notes = "Turno del empleado debe tener 5 caracteres")	
	@Size(min = 5, max = 5, message = "Turno del empleado debe tener 5 caracteres")
	@Column(name = "turno_empleado", nullable = false, length = 6)
	private String turno_empleado;

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNom_empleado() {
		return nom_empleado;
	}

	public void setNom_empleado(String nom_empleado) {
		this.nom_empleado = nom_empleado;
	}

	public String getApell_empleado() {
		return apell_empleado;
	}

	public void setApell_empleado(String apell_empleado) {
		this.apell_empleado = apell_empleado;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTurno_empleado() {
		return turno_empleado;
	}

	public void setTurno_empleado(String turno_empleado) {
		this.turno_empleado = turno_empleado;
	}

	public String getCi_empleado() {
		return ci_empleado;
	}

	public void setCi_empleado(String ci_empleado) {
		this.ci_empleado = ci_empleado;
	}
	
}
