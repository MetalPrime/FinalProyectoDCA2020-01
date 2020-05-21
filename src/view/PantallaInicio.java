package view;

import processing.core.PApplet;
import processing.core.PImage;
import controlP5.*;
import controller.ControllerInicio;

public class PantallaInicio {

	PApplet app;
	ControllerInicio controllerI;
	ControlP5 cp5;
	PImage fuego,agua,planta;
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
		fuego=app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		agua=app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		planta=app.loadImage("../imagenes/Pokemones/plantaGrande.png");
	}

	public void Pintar() {

		app.background(0);

		app.fill(255);
		
		if(cambio) {
			
			PokemonInicial();
		}
		// app.text("ya me he registrado",20,20);
	}
	
	

	public void Registrarse() {

		name = cp5.get(Textfield.class,"nombre").getText();

		controllerI.CrearJugador(name);
		cp5.hide();
		cambio=true;
	}
	
	public void PokemonInicial() {
		
		app.image(fuego, 50, 300);
		app.image(agua, 300, 350);
		app.image(planta, 600, 340);
		
	}

}
