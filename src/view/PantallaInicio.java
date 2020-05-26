package view;

import processing.core.PApplet;
import processing.core.PImage;
import controlP5.*;
import controller.ControllerInicio;

public class PantallaInicio {

	PApplet app;
	ControllerInicio controllerI;
	ControlP5 cp5;
	PImage fuego, agua, planta, fondoInicio,seleccionPokemon;
	String name;
	boolean cambio;

	public PantallaInicio(PApplet app) {

		this.app = app;
		cp5 = new ControlP5(app);
		app.fill(0);
		cp5.addTextfield("nombre").setPosition(213, 378).setSize(458, 43).setAutoClear(false);
		cp5.addBang("Registrarse").setPosition(329, 558).setSize(239, 43).setVisible(false);
		cp5.addBang("historial").setPosition(app.width / 2, app.height / 2 + 100).setSize(50, 20);
		controllerI = new ControllerInicio(app);
		cambio = false;
		fuego = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		agua = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		planta = app.loadImage("../imagenes/Pokemones/plantaGrande.png");
		fondoInicio = app.loadImage("../imagenes/pantallaRegistroUsuario.png");
		seleccionPokemon=app.loadImage("../imagenes/seleccionPokemon.jpeg");
	}

	public void Pintar() {

		app.fill(0);
		// app.text("ya me he registrado",20,20);
		if (cambio) {
			PokemonInicial();
		} else {
			app.image(fondoInicio, 0, 0);

		}
	}

	public void Registrarse() {

		name = cp5.get(Textfield.class, "nombre").getText();

		controllerI.CrearJugador(name);
		cp5.hide();
		cambio = true;
	}

	public void PokemonInicial() {

		/*app.image(fuego, 50, 300);
		app.image(agua, 300, 350);
		app.image(planta, 600, 340);
		*/
		app.image(seleccionPokemon, 0, 0);

	}

	public void SeleccionPokemon(int valor) {

		controllerI.SeleccionPokemonInicial(valor);

	}

}
