package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;

public class Logic {

	static LinkedList<Usuario> jugador = new LinkedList<Usuario>();
	PApplet app;
	String nombre;
	boolean mover;
	Pokemon[] listPokemons;

	public Logic(PApplet app) {

		this.app = app;

		mover = false;

	}

	public void CrearJugador(String nombre) {

		Jugador jugadortemp = new Jugador(app, nombre, 370, 15);
		// jugadortemp.setActivo(true);

		jugador.add(jugadortemp);

		jugador.get(jugador.size() - 1).setActivo(true);

		// PintarJugador();

	}

	public void PintarJugador() {
		System.out.println(jugador.size());

		for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {

				if (!mover) {

					jugador.get(i).Pintar();
				}

				System.out.println("funciona");

			}
		}
	}

	public void MoverPersonaje(int key) {

		for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {
				jugador.get(i).Mover(key);
				mover = true;
			}

		}

	}

	public void OrdenarUsuarios(int valor) {
		
	if(valor==0) {
		
		Collections.sort(jugador);
	}
		
		
		
	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
	}

	public static LinkedList<Usuario> getJugador() {
		return jugador;
	}

	public static void setJugador(LinkedList<Usuario> jugador) {
		Logic.jugador = jugador;
	}

}
