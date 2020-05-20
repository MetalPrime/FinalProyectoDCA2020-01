package model;

import processing.core.PApplet;

public abstract class Usuario {

	PApplet app;
	String nombre;
	// boolean activo;
	public boolean activo;

	public Usuario(PApplet app, String nombre) {

		this.app = app;
		this.nombre = nombre;

	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public abstract void Pintar();

	public abstract void Mover(int key);

}
