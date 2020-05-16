package model;

import processing.core.PApplet;

public class Logic {

	Usuario jugador;
	PApplet app;
	boolean mover;

	public Logic(PApplet app) {

		this.app = app;

		jugador = new Jugador(app, 400, 100);
		mover = false;
	}

	public void PintarJugador() {

		if (!mover) {

			jugador.Pintar();
		}

	}

	public void MoverPersonaje(int key) {

		jugador.Mover(key);
		mover = true;

	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
	}

}
