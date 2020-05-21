package controller;
import java.util.LinkedList;
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

	public void CrearJugador(String nombre) {
		
		logic.CrearJugador(nombre);

	}
	
	public LinkedList<Usuario> listaJugadores(){
		return Logic.getJugador();
		
		
	}

}
