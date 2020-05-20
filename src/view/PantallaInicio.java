package view;

import processing.core.PApplet;
import controlP5.*;
import controller.ControllerInicio;

public class PantallaInicio {

	PApplet app;
	ControllerInicio controllerI;
	ControlP5 cp5;
	String name;
	boolean cambio;

	public PantallaInicio(PApplet app) {

		this.app = app;
		cp5 = new ControlP5(app);
		cp5.addTextfield("nombre").setPosition(app.width / 2, app.height / 2).setSize(50, 20).setAutoClear(false);
		cp5.addBang("Registrarse").setPosition(app.width / 2, app.height / 2 + 20).setSize(50, 20);
		cp5.addBang("historial").setPosition(app.width / 2, app.height / 2 + 100).setSize(50, 20);
		controllerI = new ControllerInicio(app);
		cambio = false;
	}

	public void Pintar() {

		app.background(0);

		app.fill(255);
		// app.text("ya me he registrado",20,20);
	}
	
	

	public void Registrarse() {

		name = cp5.get(Textfield.class,"nombre").getText();

		controllerI.CrearJugador(name);
		//cp5.hide();
	}

}
