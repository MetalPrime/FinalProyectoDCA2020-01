package controller;

import java.util.LinkedList;

import model.Logic;
import model.Pokemon;
import processing.core.PApplet;

public class ControllerJuego {

	static Logic logic;
	PApplet app;

	public ControllerJuego(PApplet app) {
		this.app = app;
		logic = new Logic(app);
	}

	public void PintarJugador() {

		logic.PintarJugador();

	}

	public void MoverPersonaje(int key) {

		logic.MoverPersonaje(key);
	}

	public static void Detener() {
		// TODO Auto-generated method stub
		logic.setMover(false);
	}
	
	public LinkedList<Pokemon> listPokemons() {
		return logic.getListPokemons();
		
	}
	
	public void OrdenPokemon(char key) {
		logic.OrdenarPokemon(key);
	}
	
	public void mouse() {
		
		if(logic.pelea) {
			
			logic.mouseMenu();
			
		}
		
	}

}
