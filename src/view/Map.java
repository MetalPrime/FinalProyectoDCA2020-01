package view;

import processing.core.PApplet;

public class Map {
	private PApplet app;
	private float posX;
	private float posY;
	private float size;
	private int type;

	public Map(PApplet app,float posX,float posY,float size,int type) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.type = type;
	}
	
	public void paint() {
		if(this.type==0) {
			app.fill(255);
		} else if (this.type==1) {
			app.fill(255,0,0);
		} else if (this.type==2) {
			app.fill(0);
		}
		app.rect(this.posX, this.posY, this.size, this.size);
	}

	/**
	 * @return the posX
	 */
	public float getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(float posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public float getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(float posY) {
		this.posY = posY;
	}

	/**
	 * @return the size
	 */
	public float getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(float size) {
		this.size = size;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	
}
