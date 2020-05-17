package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Pokedex {
	private PApplet app;
	private PImage fondo;
	
	public Pokedex(PApplet app) {
		this.app = app;
		fondo = app.loadImage("./../imagenes/Pokedex.png");
		
	}
	
	public void paint() {
		app.image(fondo, 0, 0);
	}
	
	public void mouse() {
		
	}
	
	public void keyBoard(char key) {
		
	}
	
	public boolean closePokedex() {
		if(app.mouseX>650&&app.mouseY>650&&app.mouseX<700&&app.mouseY<700) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
