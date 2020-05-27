package controller;
import java.util.Date;
import java.util.LinkedList;

import model.Jugador;
import model.Logic;
import model.Usuario;
import processing.core.PApplet;

public class ControllerInicio {

	Logic logic;
	PApplet app;

	public ControllerInicio(PApplet app) {

		this.app = app;
		logic= new Logic(app);

	}

	public void CrearJugador(String nombre,Date date) {
		
		logic.CrearJugador(nombre,date);

	}
	
	public void SeleccionPokemonInicial(int valor) {
		
		logic.SeleccionPokemonInicial(valor);
	}
	
	public LinkedList<Jugador> listaJugadores(){
		return Logic.getJugador();
		
		
	}
	
	public void mouseMenu() {
		
	}

	public void OrdenarUsuarios(int i) {
		// TODO Auto-generated method stub
		
		logic.OrdenarUsuarios(i);
		
	}

}
