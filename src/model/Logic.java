package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import exception.OutLimitsMapException;
import processing.core.PApplet;

public class Logic {

	static LinkedList<Jugador> jugador = new LinkedList<Jugador>();
	PApplet app;
	OrdenarUsuarioFecha ordenarporFecha;
	String nombre;
	boolean mover;
	Combate combate;
	LinkedList<Pokemon> listPokemons = new LinkedList<Pokemon>();
	static LinkedList<Pokemon> salvajePokemons = new LinkedList<Pokemon>();
	private SortByLevel sortL;
	private SortByType sortT;
	public boolean pelea;

	public Logic(PApplet app) {

		this.app = app;

		mover = false;
		salvajePokemons = new LinkedList<Pokemon>();
		listPokemons.add(new Pokemon("Beaplum", 50, 1, 0, 50, "Planta", app));
		listPokemons.add(new Pokemon("Toazel", 50, 1, 0, 50, "Agua", app));
		listPokemons.add(new Pokemon("Ashtile", 50, 1, 0, 50, "Fuego", app));
		listPokemons.add(new Pokemon("Greg", 50, 1, 0, 50, "Normal", app));
		combate = new Combate(app);
		sortL = new SortByLevel();
		sortT = new SortByType();
		ordenarporFecha = new OrdenarUsuarioFecha();
	}

	public void CrearJugador(String nombre, Date date) {

		Jugador jugadortemp = new Jugador(app, nombre, 370, 15, date);
		jugador.add(jugadortemp);
		jugador.get(jugador.size() - 1).setActivo(true);

	}

	public void PintarJugador() {
		
		//System.out.println(pelea);

		for (int i = 0; i < jugador.size(); i++) {

			if (jugador.get(i).isActivo()) {

				if (!mover) {

					jugador.get(i).Pintar();
				}
			}
		}

		for (int i = 0; i < salvajePokemons.size(); i++) {
			salvajePokemons.get(i).PintarPasto();
		}
		for (int i = 0; i < jugador.size(); i++) {
			for (int j = 0; j < salvajePokemons.size(); j++) {
				if (PApplet.dist(jugador.get(i).getPosX(), jugador.get(i).getPosY(), salvajePokemons.get(j).getPosX(),
						salvajePokemons.get(j).getPosY()) < 30) {
					combate.EmpezarCombate(jugador.get(i).getPokemonJugador().get(0), salvajePokemons.get(j));
					pelea = true;

					if(combate.isCapturar()) {
						
						jugador.get(i).pokemonJugador.add(salvajePokemons.get(j));
						salvajePokemons.remove(salvajePokemons.get(j));
						pelea=false;
						combate.setCapturar(false);
						combate.setGane(false);
						System.out.println(jugador.get(i).getPokemonJugador().size());
						
					}

				}
			}
		}
		if (pelea) {
			for (Pokemon salvaje : salvajePokemons) {
				salvaje.setMover(false);
			}
		}

		for (int i = 0; i < salvajePokemons.size(); i++) {
			new Thread(salvajePokemons.get(i)).run();

		}
	}

	public void MoverPersonaje(int key) {

		if (pelea == false) {

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

	}

	public void SeleccionPokemonInicial(int valor) {
		// fuego
		if (valor == 0) {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {

					jugador.get(i).getPokemonJugador().add(listPokemons.get(2));

					// System.out.println(jugador.get(i).getPokemonJugador().get(0).getNombre());

					for (int i1 = 0; i1 < listPokemons.size(); i1++) {
						if (!jugador.get(i).getPokemonJugador().get(0).equals(listPokemons.get(i1))) {
							salvajePokemons.add(new Pokemon(listPokemons.get(i1).getNombre(),
									listPokemons.get(i1).getVida(), listPokemons.get(i1).getNivel(),
									listPokemons.get(i1).getExperiencia(), listPokemons.get(i1).getExperiencia(),
									listPokemons.get(i1).getTipo(), app));

						}
					}
				}

			}

		}

		// agua
		if (valor == 1) {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {

					jugador.get(i).getPokemonJugador().add(listPokemons.get(1));

					// System.out.println(jugador.get(i).getPokemonJugador().get(0).getNombre());

					for (int i1 = 0; i1 < listPokemons.size(); i1++) {
						if (!jugador.get(i).getPokemonJugador().get(0).equals(listPokemons.get(i1))) {
							salvajePokemons.add(new Pokemon(listPokemons.get(i1).getNombre(),
									listPokemons.get(i1).getVida(), listPokemons.get(i1).getNivel(),
									listPokemons.get(i1).getExperiencia(), listPokemons.get(i1).getExperiencia(),
									listPokemons.get(i1).getTipo(), app));

						}
					}
				}

			}

		}

		if (valor == 2) {

			for (int i = 0; i < jugador.size(); i++) {

				if (jugador.get(i).isActivo()) {

					jugador.get(i).getPokemonJugador().add(listPokemons.get(0));

					for (int i1 = 0; i1 < listPokemons.size(); i1++) {
						if (!jugador.get(i).getPokemonJugador().get(0).equals(listPokemons.get(i1))) {
							salvajePokemons.add(new Pokemon(listPokemons.get(i1).getNombre(),
									listPokemons.get(i1).getVida(), listPokemons.get(i1).getNivel(),
									listPokemons.get(i1).getExperiencia(), listPokemons.get(i1).getExperiencia(),
									listPokemons.get(i1).getTipo(), app));

						}
					}
				}

			}

		}

	}

	public void OrdenarUsuarios(int valor) {

		if (valor == 1) {

			Collections.sort(jugador);
		}

		if (valor == 2) {

			Collections.sort(jugador, ordenarporFecha);
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
