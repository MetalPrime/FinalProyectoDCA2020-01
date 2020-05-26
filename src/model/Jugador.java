package model;

import exception.OutLimitsMapException;
import processing.core.PApplet;
import processing.core.PImage;

public class Jugador extends Usuario  {

	private static boolean activo;
	PImage quieto;
	PApplet app;
	PImage[] izquierda, derecha, arriba, abajo;
	String nombre;
	Map [][] valitedMovement;
	int cols,rows,zone;
	boolean isMoving;
	int posX, posY;
	int inicialX,inicialY;

	public Jugador(PApplet app, String nombre, int posX, int posY) {
		super(app, nombre, activo);
		this.app = app;
		this.nombre = nombre;
		izquierda = new PImage[2];
		derecha = new PImage[2];
		arriba = new PImage[2];
		abajo = new PImage[2];
		izquierda[0] = app.loadImage("../imagenes/personaje/ladoQuieto.png");
		izquierda[1] = app.loadImage("../imagenes/personaje/ladoCaminando.png");

		derecha[0] = app.loadImage("../imagenes/personaje/ladoQuieto2.png");
		derecha[1] = app.loadImage("../imagenes/personaje/ladoCaminando2.png");

		arriba[0] = app.loadImage("../imagenes/personaje/arribaCaminando.png");
		arriba[1] = app.loadImage("../imagenes/personaje/arribaCaminando2.png");

		abajo[0] = app.loadImage("../imagenes/personaje/abajoCaminando.png");
		abajo[1] = app.loadImage("../imagenes/personaje/abajoCaminando2.png");

		this.posX = posX;
		this.posY = posY;
		quieto = app.loadImage("../imagenes/personaje/abajoquieto.png");
		activo = false;
		cols=15;
		rows=12;
		isMoving=false;
		inicialX = 0;
		inicialY = 6;
		
		valitedMovement = new Map[rows][cols];
		for(int i=0; i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(j == 0 && i == 11) {
					zone=1;
				} else
				
				if(i>=0 && i<11 && j==0) {
					zone=1;
				} else
				if(i>=0 && i<11 && j==14) {
					zone=1;
				} else
				if(j==6 && i==0) {
					zone=0;
				} else
				if(i>=1 && i<=3 && j!=2 && j!=4 && j!=3) {
					zone=0;
				} else if(i>=4 && i<=9) {
					zone=0;
				}else
				if(i>=1 && i<=3 && j>=2 && j<=4 ) {
					zone=1;
				}
				else {
					zone=1;
				}
				valitedMovement[i][j] = new Map(app, j*60, i*60, 60,zone);
				//System.out.println("zone"+ + zone);
			}
		}
	}

	

	public void Pintar() {
		// TODO Auto-generated method stub
		app.image(quieto, posX, posY);
		
	}

	public void Mover(int key) {
			
		
		
		
		// Izquierda

		if (key == 37) {
			
			if(valitedMovement[inicialX][inicialY-1].getType()==0) {
				for (int i = 0; i < izquierda.length; i++) {

					app.image(izquierda[app.frameCount % 2], posX, posY);


				}
				posX -= 60;
				inicialY -= 1;
			}

		

		}

		// Derecha

		if (key == 39) {

			if(valitedMovement[inicialX][inicialY+1].getType()==0) {
				for (int i = 0; i < derecha.length; i++) {

					app.image(derecha[app.frameCount % 2], posX, posY);

					
				}	
				posX += 60;
				inicialY+=1;
			}
			

		}

		// Arriba

		if (key == 38) {

			if(valitedMovement[inicialX-1][inicialY].getType()==0) {
				for (int i = 0; i < arriba.length; i++) {

					app.image(arriba[app.frameCount % 2], posX, posY);

				
				}
				posY -= 60;
				inicialX-=1;
			}
		

		}

		// Abajo

		if (key == 40) {

			if(valitedMovement[inicialX+1][inicialY].getType()==0) {
				for (int i = 0; i < abajo.length; i++) {

					app.image(abajo[app.frameCount % 2], posX, posY);
	
				}
				posY += 60;
				inicialX+=1;
			}
			

		}
		
		

	}

	@Override
	public int compareTo(Usuario o) {
		
		return this.nombre.compareTo(o.nombre);
	}



	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}



	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}



	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}



	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	

}
