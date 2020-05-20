package controller;

import java.util.ArrayList;

import model.Logic;
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
	
	public ArrayList<E>

}
