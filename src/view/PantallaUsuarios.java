package view;

import controller.ControllerInicio;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class PantallaUsuarios {

	PApplet app;
	ControllerInicio controllerInicio;
	PImage registro;
	PFont fuente;

	public PantallaUsuarios(PApplet app) {

		this.app = app;
		controllerInicio = new ControllerInicio(app);
		registro = app.loadImage("../imagenes/registros.png");
		fuente = app.createFont("../font/Pokemon Classic.ttf", 14);


	}

	public void Pintar() {

		app.background(155);
		app.image(registro, 0, 0);
		app.fill(0);
		//app.textSize(18);
		app.textFont(fuente);

		for (int i = 0; i < controllerInicio.listaJugadores().size(); i++) {

			app.text(controllerInicio.listaJugadores().get(i).getNombre(), 158, 30 * i + 235);

		}

	}
}
