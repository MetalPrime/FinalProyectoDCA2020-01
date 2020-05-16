package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego {

	PApplet app;
	PImage fondo;
	ControllerMain controllerMain;

	public PantallaJuego(PApplet app) {

		this.app = app;
		fondo = app.loadImage("../imagenes/mapa.jpg");
		controllerMain = new ControllerMain(app);

	}

	public void Pintar() {

		app.image(fondo, 0, 0);

		controllerMain.PintarPersonaje();
	}

	public void MoverPersonaje(int key) {

		controllerMain.MoverPersonaje(key);
	}
	
	public void Detener() {
		
		controllerMain.Detener();
	}

}
