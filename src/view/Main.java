package view;

import javax.naming.NoInitialContextException;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}

	PantallaJuego pantallajuego;
	PantallaInicio pantallainicio;
	PantallaUsuarios pantallaUsuarios;
	boolean pantallausuarios;
	boolean mover;
	int pantalla;

	public void settings() {

		size(901, 720);
	}

	public void setup() {

		pantallajuego = new PantallaJuego(this);
		pantallainicio = new PantallaInicio(this);
		pantallaUsuarios = new PantallaUsuarios(this);
		pantalla = 0;
		mover = false;
		frameRate(10);
	}

	public void draw() {

		// System.out.println(pantalla);

		switch (pantalla) {
		case 0:
			pantallainicio.Pintar();

			if (pantallausuarios) {
				pantallaUsuarios.Pintar();
			}
			break;
		case 1:

			pantallajuego.Pintar();
			pantallajuego.PintarPersonaje();

			break;

		default:
			break;
		}

	}

	public void mousePressed() {

		// pantalla = 1;

		if (pantalla == 0) {

			if (pantallausuarios) {

				if (mouseX > 153 && mouseX < 153 + 92 && mouseY > 194 && mouseY < 194 + 16) {

					pantallaUsuarios.OrdenarUsuarios(1);
					pantallainicio.cambio = false;
				}

				if (mouseX > 305 && mouseX < 305 + 72 && mouseY > 194 && mouseY < 194 + 16) {

					pantallaUsuarios.OrdenarUsuarios(2);
					pantallainicio.cambio = false;

				}

			}

			if (pantallainicio.inicio) {

				if (mouseX > 354 && mouseX < 354 + 416 && mouseY > 416 && mouseY < 416 + 216) {

					pantallainicio.inicio = false;
					pantallainicio.inputs = true;

				}

				if (mouseX > 300 && mouseX < 300 + 325 && mouseY > 537 && mouseY < 537 + 42) {
					pantallausuarios = true;
					pantallainicio.inputs = false;
					pantallainicio.cp5.hide();

				}

			}

			else {

				if (pantallainicio.cambio == true) {

					int valor = -1;

					if (mouseX > 99 && mouseX < 99 + 173 && mouseY > 169 && mouseY < 169 + 194) {
						valor = 0;
						pantallainicio.SeleccionPokemon(valor);
						System.out.println("fuego");
					}

					if (mouseX > 605 && mouseX < 605 + 170 && mouseY > 190 && mouseY < 190 + 170) {
						valor = 1;
						pantallainicio.SeleccionPokemon(valor);
					}

					if (mouseX > 360 && mouseX < 360 + 176 && mouseY > 180 && mouseY < 180 + 173) {
						valor = 2;
						pantallainicio.SeleccionPokemon(valor);
					}

					if (valor == -1) {
						try {
							throw new NoInitialContextException("Nel mi Perro, Tiene que seleccionar un pokemon");
						} catch (NoInitialContextException e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}

					} else {
						pantalla = 1;
					}

				}

				else {

					if (mouseX > 329 && mouseX < 329 + 239 && mouseY > 558 && mouseY < 558 + 43) {
						pantallainicio.Registrarse();
					}

				}
			}

		}
		if (pantalla == 1) {
			pantallajuego.mouse();

		}
	}

	public void keyPressed() {
		if (pantalla == 1) {
			if (key == 'ñ') {

				// pantallausuarios = true;
				pantalla = 0;
				pantallainicio.cambio = false;
				pantallainicio.inicio = true;
			}
		}
		if (pantalla == 1) {
			pantallajuego.MoverPersonaje(keyCode);
		}

		/////////////////////// ordenar pokemon
		pantallajuego.key(key);
		
		//////////// ordenar usuarios
		
	}

	public void keyReleased() {

		if (pantalla == 1) {
			pantallajuego.Detener();
		}

	}

}
