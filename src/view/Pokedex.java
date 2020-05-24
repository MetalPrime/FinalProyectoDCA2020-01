package view;

import controller.ControllerJuego;
import processing.core.PApplet;
import processing.core.PImage;

public class Pokedex {
	private PApplet app;
	private PImage fondo;
	private ControllerJuego controlador;
	
	public Pokedex(PApplet app) {
		this.app = app;
		fondo = app.loadImage("./../imagenes/Pokedex.png");
		controlador = new ControllerJuego(app);
	}
	
	public void paint() {
		app.image(fondo, 0, 0);
		
		for(int i=0; i<controlador.listPokemons().size();i++) {
			app.fill(0);
			app.textSize(20);
			app.text(controlador.listPokemons().get(i).getNombre(),600,(74*i)+280);
		}
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
