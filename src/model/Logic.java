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
	Combate combate;
	LinkedList<Pokemon> listPokemons = new LinkedList<Pokemon>();

	public Logic(PApplet app) {

		this.app = app;

		mover = false;

		listPokemons.add(new Pokemon("Beaplum", 50, 50, 50, 50, "Planta"));
		listPokemons.add(new Pokemon("Toazel", 50, 50, 50, 50, "Agua"));
		listPokemons.add(new Pokemon("Ashtile", 50, 50, 50, 50, "Fuego"));
		listPokemons.add(new Pokemon("Greg", 50, 50, 50, 50, "Normal"));
		combate = new Combate(app);

	}

	public void CrearJugador(String nombre) {

		Jugador jugadortemp = new Jugador(app, nombre, 370, 15);
		jugador.add(jugadortemp);
		jugador.get(jugador.size() - 1).setActivo(true);

	}

	public void PintarJugador() {
		System.out.println(jugador.size());

		/*for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {

				if (!mover) {

					jugador.get(i).Pintar();
				}

				System.out.println("funciona");

			}
		}
		*/
		
		combate.EmpezarCombate(jugador.get(0).getPokemonJugador().get(0), listPokemons.get(0));
	}

	public void MoverPersonaje(int key) {

		for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {
				jugador.get(i).Mover(key);
				mover = true;
			}

		}

	}

	public void SeleccionPokemonInicial(int valor) {
		// fuego
		if (valor == 0) {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {

					jugador.get(i).getPokemonJugador().add(listPokemons.get(2));

					// System.out.println(jugador.get(i).getPokemonJugador().get(0).getNombre());
				}

			}

		}

		// agua
		if (valor == 1) {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {

					jugador.get(i).getPokemonJugador().add(listPokemons.get(1));

					// System.out.println(jugador.get(i).getPokemonJugador().get(0).getNombre());
				}

			}

		}

		if (valor == 2) {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {

					jugador.get(i).getPokemonJugador().add(listPokemons.get(0));
				}

			}

		}
	}

	public void OrdenarUsuarios(int valor) {

		if (valor == 0) {

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

	/**
	 * @return the listPokemons
	 */
	public LinkedList<Pokemon> getListPokemons() {
		return listPokemons;
	}

	/**
	 * @param listPokemons the listPokemons to set
	 */
	public void setListPokemons(LinkedList<Pokemon> listPokemons) {
		this.listPokemons = listPokemons;
	}

}
