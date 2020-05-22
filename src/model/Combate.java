package model;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Combate {

	PApplet app;
	PImage dialogoPokemon;
	PImage menuAtaque, fuego, agua, planta,fuegoF,aguaF,plantaF;
	PFont fuente;
	boolean dialogo;

	public Combate(PApplet app) {

		this.app = app;
		dialogoPokemon = app.loadImage("../imagenes/combate/combateAnuncioVacio.png");
		menuAtaque = app.loadImage("../imagenes/combate/combateAtaquesPrincipal.png");
		dialogo = true;
		fuente = app.createFont("../font/Pokemon Classic.ttf", 30);
		fuego = app.loadImage("../imagenes/Pokemones/fuegoGrandeEspalda.png");
		agua = app.loadImage("../imagenes/Pokemones/aguaGrandeEspalda.png");
		planta = app.loadImage("../imagenes/Pokemones/plantaGrandeEspalda.png");
		
		fuegoF = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		aguaF = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		plantaF = app.loadImage("../imagenes/Pokemones/plantaGrande.png");

	}

	public void EmpezarCombate(Pokemon jugador, Pokemon maquina) {

		app.background(0);

		// app.image(dialogoPokemon, 371, 494);
		app.fill(255, 0, 0);
		// app.text(maquina.getNombre()+"quiere pelear", 380, 500);
		
		//Pokemon Jugador
		if (jugador.getTipo().contentEquals("Fuego")) {

			app.image(fuego, 57, 350);
		}
		if (jugador.getTipo().contentEquals("Agua")) {

			app.image(agua, 57, 350);
		}

		else if (jugador.getTipo().contentEquals("Planta")) {

			app.image(planta, 57, 350);
		}
		
		//Pokemon maquina
		

		if (maquina.getTipo().contentEquals("Fuego")) {

			app.image(fuegoF, 573, 36);
		}
		if (maquina.getTipo().contentEquals("Agua")) {

			app.image(aguaF, 573, 36);
		}

		else if (maquina.getTipo().contentEquals("Planta")) {

			app.image(plantaF, 573, 36);
		}

		
		app.image(menuAtaque, 0, 494);

	}

}
