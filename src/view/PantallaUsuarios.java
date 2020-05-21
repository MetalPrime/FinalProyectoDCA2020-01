package view;

import controller.ControllerInicio;
import processing.core.PApplet;

public class PantallaUsuarios {

	PApplet app;
	ControllerInicio controllerInicio;

	public PantallaUsuarios(PApplet app) {

		this.app = app;
		controllerInicio = new ControllerInicio(app);

	}

	public void Pintar() {

		app.background(155);

		for (int i = 0; i < controllerInicio.listaJugadores().size(); i++) {

			app.text(controllerInicio.listaJugadores().get(i).getNombre(), 60, 30 * i + 20);

		}

	}
}
