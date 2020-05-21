package model;

import processing.core.PApplet;

public abstract class Usuario implements Comparable <Usuario> {

	PApplet app;
	String nombre;
	// boolean activo;
	public boolean activo;

	public Usuario(PApplet app, String nombre,boolean activo) {

		this.app = app;
		this.nombre = nombre;
		this.activo=activo;

	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public abstract void Pintar();

	public abstract void Mover(int key);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
