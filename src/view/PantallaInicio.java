package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.text.SimpleDateFormat;
import java.util.Date;

import controlP5.*;
import controller.ControllerInicio;

public class PantallaInicio {

	PApplet app;
	ControllerInicio controllerI;
	ControlP5 cp5;
	PImage fuego, agua, planta, fondoInicio, seleccionPokemon, primerPantalla;
	String name;
	boolean inicio, inputs;

	boolean cambio;
	PFont fuente;

	public PantallaInicio(PApplet app) {

		this.app = app;
		cp5 = new ControlP5(app);
		app.fill(0);
		cp5.addTextfield("nombre").setPosition(213, 378).setSize(458, 43).setAutoClear(false);
		cp5.addBang("Registrarse").setPosition(329, 558).setSize(239, 43).setVisible(false);
		cp5.addBang("historial").setPosition(app.width / 2, app.height / 2 + 100).setSize(50, 20).setVisible(false);
		controllerI = new ControllerInicio(app);
		cambio = false;
		fuente = app.createFont("../font/Pokemon Classic.ttf", 14);

		fuego = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		agua = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		planta = app.loadImage("../imagenes/Pokemones/plantaGrande.png");
		fondoInicio = app.loadImage("../imagenes/pantallaRegistroUsuario.png");
		seleccionPokemon = app.loadImage("../imagenes/seleccionPokemon.jpeg");
		primerPantalla = app.loadImage("../imagenes/PantallaInicio.png");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		cp5.setFont(fuente,10);
		

		inicio = true;
		cp5.hide();
	}

	public void Pintar() {

		if (inicio) {

			app.image(primerPantalla, 0, 0);
		}

		else if (inicio == false) {

			if (inputs) {
				cp5.show();
			}
			if (cambio) {
				PokemonInicial();
			} else {
				app.image(fondoInicio, 0, 0);

			}
		}
	}

	public void Registrarse() {

		if (inicio == false) {

			name = cp5.get(Textfield.class, "nombre").getText();

			Date date = new Date();

			controllerI.CrearJugador(name, date);
			cp5.get(Textfield.class, "nombre").clear();
			cp5.hide();
			cambio = true;
			inputs = false;
		}
	}

	public void PokemonInicial() {

		app.image(seleccionPokemon, 0, 0);

	}

	public void SeleccionPokemon(int valor) {

		controllerI.SeleccionPokemonInicial(valor);

	}
	
	public void ordenarUsuarios(char valor) {
		controllerI.OrdenarUsuarios(valor);
	}

}
