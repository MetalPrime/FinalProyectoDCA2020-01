package view;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}

	PantallaJuego pantallajuego;
	PantallaInicio pantallainicio;
	boolean mover;
	int pantalla;

	public void settings() {

		size(901, 720);
	}

	public void setup() {

		pantallajuego = new PantallaJuego(this);
		pantallainicio = new PantallaInicio(this);
		pantalla = 0;
		mover = false;
		frameRate(10);
	}

	public void draw() {

		switch (pantalla) {
		case 0:
			pantallainicio.Pintar();
			break;
		case 1:

			pantallajuego.Pintar();

			break;

		default:
			break;
		}

	}

	public void mousePressed() {

		pantalla = 1;
		pantallajuego.mouse();
	}

	public void keyPressed() {

		pantallajuego.MoverPersonaje(keyCode);

	}

	public void keyReleased() {

		pantallajuego.Detener();

	}

}
