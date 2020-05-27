package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Rival extends Usuario{


	private PImage quieto;
	private int posX;
	private int posY;

	public Rival(PApplet app,String nombre,boolean activo) {
		// TODO Auto-generated constructor stub
		super(app, nombre, activo);
		quieto = app.loadImage("../imagenes/rival/rivalFrente.png");
		posX = 180; 
		posY = 240;
	}

	

	@Override
	public void Pintar() {
		// TODO Auto-generated method stub
		app.image(quieto, posX,posY);
	}

	@Override
	public void Mover(int key) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int compareTo(Usuario arg0) {
		// TODO Auto-generated method stub
		return 0;
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
