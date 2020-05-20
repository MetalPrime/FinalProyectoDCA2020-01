package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {

	ArrayList<Usuario> jugador = new ArrayList<Usuario>();
	PApplet app;
	String nombre;
	boolean mover;
	Pokemon[] listPokemons;

	public Logic(PApplet app) {

		this.app = app;

		mover = false;

	}

	public void PintarJugador() {

		for (int i = 0; i < jugador.size(); i++) {
			System.out.println(i);
			
			if (jugador.get(i).isActivo()) {

				 if (!mover) {

				 jugador.get(i).Pintar();
				 }

				System.out.println("funciona");

			}
		}
	}

	public void CrearJugador(String nombre) {

		Jugador jugadortemp = new Jugador(app, nombre, 400, 100);
		//jugadortemp.setActivo(true);

		jugador.add(jugadortemp);
		
		jugador.get(jugador.size()-1).setActivo(true);

		PintarJugador();

	}

	public void MoverPersonaje(int key) {

		for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {
				jugador.get(i).Mover(key);
				mover = true;
			}

		}

	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
	}

}
