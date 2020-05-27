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
		app.fill(0);
		app.rect(50, 50, 150, 25);
		app.fill(255);
		app.textSize(12);
		app.text("Pokedex", 90, 65);
		if (isPokedex) {
			pokedexScreen.paint();
			app.fill(255);
			app.rect(650, 650, 50, 50);
			app.fill(0);
			app.textSize(12);
			app.text("Close", 650, 675);
		}
		

	}

	public void PintarPersonaje() {
		if(isPokedex==false) {
			controllerMain.PintarPersonaje();
		}
		
	}

	public void MoverPersonaje(int key) {
		
			controllerMain.MoverPersonaje(key);
		
	}

	public void Detener() {
		controllerMain.Detener();
	
		
	}

	public void mouse() {
		
		if (app.mouseX > 50 && app.mouseY > 50 && app.mouseX < 200 && app.mouseY < 75) {
			isPokedex = true;
		}
		if (pokedexScreen.closePokedex()) {
			System.out.println(pokedexScreen.closePokedex());
			isPokedex = false;
		}
		pokedexScreen.mouse();
		
		controllerMain.mouse();
	}
	
	public void key(char key) {
		pokedexScreen.keyBoard(key);
	}

}
