package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Jugador extends Usuario {

	PImage quieto;
	PApplet app;
	PImage[] izquierda, derecha, arriba, abajo;

	int posX, posY;

	public Jugador(PApplet app, int posX, int posY) {
		super(app);
		this.app = app;
		izquierda = new PImage[2];
		derecha = new PImage[2];
		arriba = new PImage[2];
		abajo = new PImage[2];
		izquierda[0] = app.loadImage("../imagenes/personaje/ladoQuieto.png");
		izquierda[1] = app.loadImage("../imagenes/personaje/ladoCaminando.png");
		
		derecha[0] = app.loadImage("../imagenes/personaje/ladoQuieto2.png");
		derecha[1] = app.loadImage("../imagenes/personaje/ladoCaminando2.png");
		
		arriba[0]=app.loadImage("../imagenes/personaje/arribaCaminando.png");
		arriba[1]=app.loadImage("../imagenes/personaje/arribaCaminando2.png");
		
		abajo[0]=app.loadImage("../imagenes/personaje/abajoCaminando.png");
		abajo[1]=app.loadImage("../imagenes/personaje/abajoCaminando2.png");

		this.posX = posX;
		this.posY = posY;
		quieto = app.loadImage("../imagenes/personaje/abajoquieto.png");
	}

	public void Pintar() {
		// TODO Auto-generated method stub
		System.out.println("funciona");
		app.image(quieto, posX, posY);
	}

	public void Mover(int key) {
		
		//Izquierda

		if (key == 37) {

			for (int i = 0; i < izquierda.length; i++) {

				app.image(izquierda[app.frameCount % 2], posX, posY);

				posX -= 1;
			}

		}
		
		//Derecha

		if (key == 39) {

			for (int i = 0; i < derecha.length; i++) {

				app.image(derecha[app.frameCount % 2], posX, posY);

				posX += 1;

			}

		}
		
		//Arriba
		
		if (key == 38) {

			for (int i = 0; i < arriba.length; i++) {

				app.image(arriba[app.frameCount % 2], posX, posY);

				posY -= 1;

			}

		}
		
		//Abajo
		
		
		if (key == 40) {

			for (int i = 0; i < abajo.length; i++) {

				app.image(abajo[app.frameCount % 2], posX, posY);

				posY += 1;

			}

		}
		

	}

}
