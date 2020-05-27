package model;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Combate {

	PApplet app;
	PImage dialogoPokemon;
	PImage menuAtaque, fuego, agua, planta, fuegoF, aguaF, plantaF, ataqueFuego, ataqueagua, ataqueplanta, vidaJugador,
			vidaenemigo, normal, vacio;
	PFont fuente;
	int barraMaquina, tamañobarra;
	int turno;
	boolean menúPelea, capturar;
	Pokemon maquina, jugador;
	boolean gane;

	public Combate(PApplet app) {

		this.app = app;
		dialogoPokemon = app.loadImage("../imagenes/combate/combateAnuncioVacio.png");
		menuAtaque = app.loadImage("../imagenes/combate/combateAtaquesPrincipal.png");
		//dialogo = true;
		fuente = app.createFont("../font/Pokemon Classic.ttf", 25);
		fuego = app.loadImage("../imagenes/Pokemones/fuegoGrandeEspalda.png");
		turno = 1;
		agua = app.loadImage("../imagenes/Pokemones/aguaGrandeEspalda.png");
		planta = app.loadImage("../imagenes/Pokemones/plantaGrandeEspalda.png");

		fuegoF = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		aguaF = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		plantaF = app.loadImage("../imagenes/Pokemones/plantaGrande.png");
		ataqueFuego = app.loadImage("../imagenes/combate/combateAtaquesFuego.png");
		ataqueagua = app.loadImage("../imagenes/combate/combateAtaquesAgua.png");
		ataqueplanta = app.loadImage("../imagenes/combate/combateAtaquesPlanta.png");
		vidaJugador = app.loadImage("../imagenes/combate/VidaJugador.png");
		vidaenemigo = app.loadImage("../imagenes/combate/VidasEnemigos.png");
		normal = app.loadImage("../imagenes/Pokemones/NormalGrande.png");
		vacio = app.loadImage("imagenes/combate/cuadro vacio.png");
		gane = false;
		capturar = false;
	}

	public void EmpezarCombate(Pokemon jugador, Pokemon maquina) {

		this.jugador = jugador;
		this.maquina = maquina;
		app.background(255);
		System.out.println(menúPelea);
		app.textFont(fuente);
		// System.out.println(gane);

		VerificarVida(this.jugador, this.maquina);
		tamañobarra = (int) PApplet.map(this.jugador.getVida(), 0, 50, 0, 197);
		barraMaquina = (int) PApplet.map(this.maquina.getVida(), 0, 50, 0, 197);
		// app.image(dialogoPokemon, 371, 494);
		// app.fill(255, 0, 0);
		// app.text(maquina.getNombre()+"quiere pelear", 380, 500);
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

		if (maquina.getTipo().contentEquals("Normal")) {

			app.image(normal, 573, 36);

		}
		if (maquina.getTipo().contentEquals("Agua")) {

			app.image(aguaF, 573, 36);
		}

		else if (maquina.getTipo().contentEquals("Planta")) {

			app.image(plantaF, 573, 36);
		}

		app.fill(0);

		app.text(this.jugador.getNombre(), 506, 380);
		app.text(this.maquina.getNombre(), 70, 80);
		app.textSize(20);
		app.text(this.jugador.getNivel(), 672, 406);
		app.text(this.maquina.getNivel(), 243, 114);
		app.image(menuAtaque, 0, 494);
		app.image(vidaJugador, 468, 376);
		app.image(vidaenemigo, 55, 90);
		app.fill(0, 255, 0);

		// barra de vida jugador

		if (this.jugador.getNivel() <= 25 || this.maquina.getVida() <= 25) {

			app.fill(255, 255, 0);
		}

		else if (this.jugador.getVida() <= 15 || this.maquina.getVida() <= 15) {

			app.fill(255, 0, 0);
		}
		app.rect(579, 427, tamañobarra, 12);
		app.rect(151, 134, barraMaquina, 12);

		// Menu Pelea

		if (!(jugador.getVida() <= 0 || maquina.getVida() <= 0)) {

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
		}

		if (gane) {

			app.image(vacio, 0, 489);
			app.fill(0);
			app.textSize(26);
			app.text("Capturar", 547, 610);

		}

	}

	public void Menú() {

		// System.out.println("click");
		// Pelear
		
			if (app.mouseX > 458 && app.mouseX < 458 + 157 && app.mouseY > 550 && app.mouseY < 550 + 48) {

				// app.image(ataqueFuego, 0, 494);
				menúPelea = true;

			}
		

		if (menúPelea == false && gane) {

			if (app.mouseX > 547 && app.mouseX < 547 + 139 && app.mouseY > 573 && app.mouseY < 573 + 42) {

				capturar = true;
				menúPelea = true;
				gane = false;
				// maquina.setVida(50);

			}
		}

		if (menúPelea) {

			if (turno == 1) {

				if (app.mouseX > 442 && app.mouseX < 442 + 288 && app.mouseY > 542 && app.mouseY < 542 + 31) {
					System.out.println("primer ataque");

					if (jugador.getTipo().contentEquals("Fuego")) {

						Llamarada(maquina);

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

		if (maquina.getTipo().contentEquals("Fuego") || maquina.getTipo().contentEquals("Normal")) {

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

		if (victima == this.jugador) {

			victima.setVida(victima.getVida() - 10);

		} else {
			victima.setVida(victima.getVida() - 15);
			jugador.setExperiencia(jugador.getExperiencia() + 7);

		}
		turno *= -1;

	}

	public void Mordida(Pokemon victima) {

		if (victima == this.jugador) {

			victima.setVida(victima.getVida() - 8);

		} else {

			victima.setVida(victima.getVida() - 10);
			jugador.setExperiencia(jugador.getExperiencia() + 5);

		}
		turno *= -1;

	}

	public void Lenguetazo(Pokemon victima) {

		if (victima == this.jugador) {

			victima.setVida(victima.getVida() - 10);

		} else {
			victima.setVida(victima.getVida() - 15);
			jugador.setExperiencia(jugador.getExperiencia() + 10);

		}
		turno *= -1;

	}

	public void Embestida(Pokemon victima) {

		if (victima == this.jugador) {
			victima.setVida(victima.getVida() - 10);
		}

		else {

			victima.setVida(victima.getVida() - 20);
			jugador.setExperiencia(jugador.getExperiencia() + 5);

		}
		turno *= -1;

	}

	public void AtaqueHoja(Pokemon victima) {

		if (victima == this.jugador) {

			victima.setVida(victima.getVida() - 10);

		} else {
			victima.setVida(victima.getVida() - 15);
			jugador.setExperiencia(jugador.getExperiencia() + 10);

		}
		turno *= -1;

	}

	public void VerificarVida(Pokemon jugador, Pokemon maquina) {

		if (jugador.getVida() <= 0) {
			jugador.setVida(0);
		}

		else if (maquina.getVida() <= 0) {

			// System.out.println("GG");
			maquina.setVida(0);
			jugador.setVida(50);
			gane = true;
			menúPelea = false;

		}

	}

	public boolean isGane() {
		return gane;
	}

	public void setGane(boolean gane) {
		this.gane = gane;
	}

	public boolean isCapturar() {
		return capturar;
	}

	public void setCapturar(boolean capturar) {
		this.capturar = capturar;
	}
}
