package model;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import exception.OutLevelException;
import exception.OutLimitsMapException;
import processing.core.PApplet;

public class Logic {

	static LinkedList<Jugador> jugador = new LinkedList<Jugador>();
	PApplet app;
	OrdenarUsuarioFecha ordenarporFecha;
	String nombre;
	boolean mover;
	Combate combate,combateRival;
	LinkedList<Pokemon> listPokemons = new LinkedList<Pokemon>();
	static LinkedList<Pokemon> salvajePokemons = new LinkedList<Pokemon>();
	private Rival rival;
	private SortByLevel sortL;
	private SortByType sortT;
	public boolean pelea,peleaRival;
	private int randomPelea;
	private int randomEnemyPokemon;


	public Logic(PApplet app) {

		this.app = app;

		mover = false;
		salvajePokemons = new LinkedList<Pokemon>();
		listPokemons.add(new Pokemon("Beaplum", 50, 1, 0, 50, "Planta", app));
		listPokemons.add(new Pokemon("Toazel", 50, 1, 0, 50, "Agua", app));
		listPokemons.add(new Pokemon("Ashtile", 50, 1, 0, 50, "Fuego", app));
		listPokemons.add(new Pokemon("Greg", 50, 1, 0, 50, "Normal", app));
		combate = new Combate(app);
		combateRival = new Combate(app);
		sortL = new SortByLevel();
		sortT = new SortByType();
		ordenarporFecha= new OrdenarUsuarioFecha();
		//jugador.add(new Jugador(app, "NIGGA", 10, 10));
		//System.out.println(jugador.size());
		rival = new Rival(app, "Rival Generico", false);
		for(int i=0; i<2; i++) {
			randomEnemyPokemon = (int) app.random(0,4);
			rival.pokemonJugador.add(listPokemons.get(randomEnemyPokemon));
		}
		

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
						//System.out.println(jugador.get(i).getPokemonJugador().size());
						
					}

				}
			}
		}

		
	/*	if(randomPelea>=75 && randomPelea<=100) {
			for (int i = 0; i < jugador.size(); i++) {
			for (int j = 0; j < salvajePokemons.size(); j++) {
					//System.out.println("esta entrando");
					
					combate.EmpezarCombate(jugador.get(i).getPokemonJugador().get(0),
					salvajePokemons.get(j));
				 	pelea=true;
			}
				
			}
		}*/
		
		for(int i=0; i< salvajePokemons.size(); i++) {
			new Thread(salvajePokemons.get(i)).start();
			
		}
		if(pelea==false) {
			rival.Pintar();
		}
		
		System.out.println(rival.getPokemonJugador().size());
		
		if(PApplet.dist(jugador.get(0).getPosX(), jugador.get(0).getPosY(),rival.getPosX(),rival.getPosY())<30) {
			try {
				if(jugador.get(0).getPokemonJugador().size()>=2) {
					combateRival.EmpezarCombate(jugador.get(0).getPokemonJugador().get(0), rival.getPokemonJugador().get(1));
				 	peleaRival=true;
				 	pelea= true;
				 	
				 	if(combateRival.isCapturar()) {
						
						pelea=false;
						combate.setCapturar(false);
						combate.setGane(false);
						app.background(0);
						app.textSize(50);
						app.fill(255);
						app.text("Ganaste",app.height/2-50,app.width/2-50);
						//System.out.println(jugador.get(i).getPokemonJugador().size());
						
					}
				}
				else {
					throw new OutLevelException("No estas listo para mi");
				}
			} catch (OutLevelException e) {
				// TODO: handle exception
				app.fill(255);
				app.rect(120,120,220,40);
				app.fill(0);
				app.text(e.getMessage(), 130, 150);
			}
		}
		
		if (pelea) {
			for (Pokemon salvaje : salvajePokemons) {
				salvaje.setMover(false);
			}
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
		if(peleaRival==true) {
			combateRival.Menú();
		}
		
	}

}
