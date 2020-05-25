package model;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Combate {

	PApplet app;
	PImage dialogoPokemon;
	PImage menuAtaque, fuego, agua, planta, fuegoF, aguaF, plantaF, ataqueFuego, ataqueagua, ataqueplanta, vidaJugador;
	PFont fuente;
	int barraJugador, tamañobarra;
	int turno;
	boolean menúPelea;
	Pokemon maquina, jugador;
	boolean dialogo;

	public Combate(PApplet app) {

		this.app = app;
		dialogoPokemon = app.loadImage("../imagenes/combate/combateAnuncioVacio.png");
		menuAtaque = app.loadImage("../imagenes/combate/combateAtaquesPrincipal.png");
		dialogo = true;
		fuente = app.createFont("../font/Pokemon Classic.ttf", 30);
		fuego = app.loadImage("../imagenes/Pokemones/fuegoGrandeEspalda.png");
		turno = -1;
		agua = app.loadImage("../imagenes/Pokemones/aguaGrandeEspalda.png");
		planta = app.loadImage("../imagenes/Pokemones/plantaGrandeEspalda.png");

		fuegoF = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		aguaF = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		plantaF = app.loadImage("../imagenes/Pokemones/plantaGrande.png");
		ataqueFuego = app.loadImage("../imagenes/combate/combateAtaquesFuego.png");
		ataqueagua = app.loadImage("../imagenes/combate/combateAtaquesAgua.png");
		ataqueplanta = app.loadImage("../imagenes/combate/combateAtaquesPlanta.png");
		vidaJugador = app.loadImage("../imagenes/combate/VidaJugador.png");
		// tamañobarra = (int) PApplet.map(tamañobarra, this.jugador.getVida(), 0, 0,
		// 197)

	}

	public void EmpezarCombate(Pokemon jugador, Pokemon maquina) {

		this.jugador = jugador;
		this.maquina = maquina;

		app.background(255);

		VerificarVida(this.jugador, this.maquina);
		
		app.text(this.jugador.getVida(), 50, 50);
		app.text(this.maquina.getVida(), 100, 100);

		// barraJugador = jugador.getVida();

		// app.image(dialogoPokemon, 371, 494);
		// app.fill(255, 0, 0);
		// app.text(maquina.getNombre()+"quiere pelear", 380, 500);

		// Pokemon Jugador
		if (jugador.getTipo().contentEquals("Fuego")) {

			app.image(fuego, 57, 350);
		}
		if (jugador.getTipo().contentEquals("Agua")) {

			app.image(agua, 57, 350);
		}

		else if (jugador.getTipo().contentEquals("Planta")) {

			app.image(planta, 57, 350);
		}

		// Pokemon maquina

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
		app.image(vidaJugador, 468, 376);
		app.fill(0, 255, 0);
		app.rect(579, 423, tamañobarra, 21);
		// System.out.println(tamañobarra);

		// Menu Pelea
		
		if(!(jugador.getVida()<=0||maquina.getVida()<=0)) {

		if (menúPelea) {

			if (jugador.getTipo().contentEquals("Fuego")) {

				app.image(ataqueFuego, 0, 494);
			}
			if (jugador.getTipo().contentEquals("Agua")) {

				app.image(ataqueagua, 0, 494);
			}

			else if (jugador.getTipo().contentEquals("Planta")) {

				app.image(ataqueplanta, 0, 494);
			}

		}

		if (turno == -1) {
			AtaqueMaquina();
		}

		// System.out.println("vida jugador"+jugador.getVida()+" "+"vida
		// maquina"+maquina.getVida());
		}
	}

	public void Menú() {

		// System.out.println("click");
		// Pelear
		if (app.mouseX > 458 && app.mouseX < 458 + 157 && app.mouseY > 550 && app.mouseY < 550 + 48) {

			// app.image(ataqueFuego, 0, 494);
			menúPelea = true;

		}

		if (menúPelea) {

			if (turno == 1) {

				System.out.println("me tocá");
				// PrimerAtaque

				if (app.mouseX > 442 && app.mouseX < 442 + 288 && app.mouseY > 542 && app.mouseY < 542 + 31) {
					System.out.println("primer ataque");

					if (jugador.getTipo().contentEquals("Fuego")) {

						Llamarada(maquina);
						// Mordida(jugador);

					}
					if (jugador.getTipo().contentEquals("Agua")) {

						Lenguetazo(maquina);
						System.out.println("ataqué");
					}

					else if (jugador.getTipo().contentEquals("Planta")) {

						AtaqueHoja(maquina);

					}

				}

				else if (app.mouseX > 442 && app.mouseX < 442 + 288 && app.mouseY > 580 && app.mouseY < 580 + 31) {

					if (jugador.getTipo().contentEquals("Fuego")) {

						Mordida(maquina);

					}
					if (jugador.getTipo().contentEquals("Agua")) {

						Embestida(maquina);

					}

					else if (jugador.getTipo().contentEquals("Planta")) {

						Embestida(maquina);
					}

				}

			}

		}

	}

	public void AtaqueMaquina() {

		if (maquina.getTipo().contentEquals("Fuego")) {

			int random;
			random = (int) app.random(1, 2);

			if (random == 1) {

				Llamarada(jugador);
			}

			else {

				Mordida(jugador);
			}

		}
		if (maquina.getTipo().contentEquals("Agua")) {

			int random;
			random = (int) app.random(1, 2);

			if (random == 1) {

				Llamarada(jugador);
			}

			else {

				Mordida(jugador);
			}

		}

		else if (maquina.getTipo().contentEquals("Planta")) {

			int random;
			random = (int) app.random(1, 2);

			if (random == 1) {

				AtaqueHoja(jugador);
			}

			else {

				Embestida(jugador);
			}

		}

	}

	public void Llamarada(Pokemon victima) {
		
		if(victima==this.jugador) {
			
			victima.setVida(victima.getVida()-10);
		}
		else {
		victima.setVida(victima.getVida() - 20);
		}
		turno *= -1;

	}

	public void Mordida(Pokemon victima) {
		
		if(victima==this.jugador) {
			
			victima.setVida(victima.getVida()-10);
		}
		else {

		victima.setVida(victima.getVida() - 10);
		}
		turno *= -1;

	}

	public void Lenguetazo(Pokemon victima) {

		victima.setVida(victima.getVida() - 15);
		turno *= -1;

	}

	public void Embestida(Pokemon victima) {

		victima.setVida(victima.getVida() - 10);
		turno *= -1;

	}

	public void AtaqueHoja(Pokemon victima) {

		victima.setVida(victima.getVida() - 20);
		turno *= -1;

	}

	public void VerificarVida(Pokemon jugador, Pokemon maquina) {

		if (jugador.getVida() <= 0) {

			System.out.println("rip");
		}

		else if (maquina.getVida() <= 0) {

			System.out.println("GG");
		}

	}
}
