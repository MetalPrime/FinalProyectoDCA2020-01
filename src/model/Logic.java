package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import exception.OutLimitsMapException;
import processing.core.PApplet;

public class Logic {

	static LinkedList<Jugador> jugador = new LinkedList<Jugador>();
	PApplet app;
	String nombre;
	boolean mover;
	Combate combate;
	LinkedList<Pokemon> listPokemons = new LinkedList<Pokemon>();
	private SortByLevel sortL;
	private SortByType sortT;
	public boolean pelea;

	public Logic(PApplet app) {

		this.app = app;

		mover = false;

		listPokemons.add(new Pokemon("Beaplum", 50, 1, 50, 50, "Planta",app));
		listPokemons.add(new Pokemon("Toazel", 50, 1, 50, 50, "Agua",app));
		listPokemons.add(new Pokemon("Ashtile", 50, 1, 50, 50, "Fuego",app));
		listPokemons.add(new Pokemon("Greg", 50, 1, 50, 50, "Normal",app));
		combate = new Combate(app);
		sortL = new SortByLevel();
		sortT = new SortByType();
	}

	public void CrearJugador(String nombre) {

		Jugador jugadortemp = new Jugador(app, nombre, 370, 15);
		jugador.add(jugadortemp);
		jugador.get(jugador.size() - 1).setActivo(true);

	}

	public void PintarJugador() {

		for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {

				if (!mover) {

					jugador.get(i).Pintar();
				}

				//System.out.println("funciona");

			}
		}

		
		for (int i = 0; i < listPokemons.size(); i++) {
			listPokemons.get(i).PintarPasto();
		}
		
		if(PApplet.dist(jugador.get(0).getPosX(), jugador.get(0).getPosY(),listPokemons.get(0).getPosX() ,listPokemons.get(0).getPosY())<30) {
			//System.out.println("esta entrando");
			combate.EmpezarCombate(jugador.get(0).getPokemonJugador().get(0),
			listPokemons.get(2));
		 	pelea=true;
			mouseMenu();

		}
	
	}

	public void MoverPersonaje(int key) {

		try {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {
					jugador.get(i).Mover(key);
					mover = true;
				}

			}

		} catch (ArrayIndexOutOfBoundsException E) {
			System.out.println(E.getMessage());
			System.out.println(new OutLimitsMapException("Esta sección esta fuera de los limites"));
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

	public void OrdenarPokemon(char key) {
		switch (key) {
		case 'n':
			Collections.sort(listPokemons);
			break;
		case 'l':
			Collections.sort(listPokemons, sortL);
			break;
		case 't':
			Collections.sort(listPokemons, sortT);
			break;
		}

	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
	}

	public static LinkedList<Jugador> getJugador() {
		return jugador;
	}

	public static void setJugador(LinkedList<Jugador> jugador) {
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

	public void mouseMenu() {
		// TODO Auto-generated method stub
		combate.Menú();
	}

}
