package model;

import org.apache.log4j.Logger;

public final class PersonaVO {

	private int id;
	private String nombre;
	private int edad;
	private String profesion;
	private String telefono;

	public static final Logger LOG = Logger.getLogger(PersonaVO.class);

	public PersonaVO() {

	}

	public PersonaVO(int id, String nombre, int edad, String profesion, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.profesion = profesion;
		this.telefono = telefono;
	}

	public Object clone() {
		Object clon = null;

		try {
			clon = super.clone();
		} catch (CloneNotSupportedException e) {

		}
		return clon;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
