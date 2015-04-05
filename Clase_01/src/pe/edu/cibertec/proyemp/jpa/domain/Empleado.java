package pe.edu.cibertec.proyemp.jpa.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String nombre;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	private Departamento departamento;

	public Empleado() {
	}

	public Empleado(String nombre, Departamento departamento) {
		this.nombre = nombre;
		this.departamento = departamento;
	}

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}