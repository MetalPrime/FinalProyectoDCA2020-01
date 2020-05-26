package view;

import controller.ControllerMain;
import model.Map;
import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego {

	PApplet app;
	PImage fondo;
	ControllerMain controllerMain;
	Pokedex pokedexScreen;
	boolean isPokedex;
	

	public PantallaJuego(PApplet app) {

		this.app = app;
		fondo = app.loadImage("../imagenes/mapa.jpg");
		controllerMain = new ControllerMain(app);
		pokedexScreen = new Pokedex(app);

	}

	public void Pintar() {

		app.image(fondo, 0, 0);

		if (isPokedex) {
			pokedexScreen.paint();
		}
		

	}

	public void PintarPersonaje() {

		controllerMain.PintarPersonaje();
	}

	public void MoverPersonaje(int key) {
		
			controllerMain.MoverPersonaje(key);
		
	}

	public void Detener() {
		controllerMain.Detener();
	
		
	}

	public void mouse() {
		
		if (app.mouseX > 50 && app.mouseY > 50 && app.mouseX < 100 && app.mouseY < 100) {
			isPokedex = true;
		}
		if (pokedexScreen.closePokedex()) {
			System.out.println(pokedexScreen.closePokedex());
			isPokedex = false;
		}
		pokedexScreen.mouse();
		
		controllerMain.mouse();
		//if(logi)
	}
	
	public void key(char key) {
		pokedexScreen.keyBoard(key);
	}

}
