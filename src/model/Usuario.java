package model;

import processing.core.PApplet;

public abstract class Usuario {

	PApplet app;

	public Usuario(PApplet app) {

		this.app = app;

	}

	public abstract void Pintar();

	public abstract void Mover(int key);

}
