package controller;

import processing.core.PApplet;

public class ControllerMain {

	PApplet app;
	ControllerJuego controllerJuego;

	public ControllerMain(PApplet app) {

		this.app = app;
		controllerJuego = new ControllerJuego(app);
	}
	
	public void PintarPersonaje() {
		
		controllerJuego.PintarJugador();
		
	}
	
	
	public void MoverPersonaje(int key) {
		
		controllerJuego.MoverPersonaje(key);
		
	}

	public void Detener() {
		// TODO Auto-generated method stub
		ControllerJuego.Detener();
		
	}
	
	public void mouse() {
		
		controllerJuego.mouse();
	}
	
	
}
