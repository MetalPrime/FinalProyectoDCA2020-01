package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego {

	PApplet app;
	PImage fondo;
	ControllerMain controllerMain;
	Pokedex pokedexScreen;
	boolean isPokedex;
	int cols,rows,zone;
	Map [][] valitedMovement;

	public PantallaJuego(PApplet app) {

		this.app = app;
		fondo = app.loadImage("../imagenes/mapa.jpg");
		controllerMain = new ControllerMain(app);
		pokedexScreen = new Pokedex(app);
		cols=15;
		rows=12;
		
		valitedMovement = new Map[rows][cols];
		for(int i=0; i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(j == 0 && i == 11) {
					zone=1;
				} 
				if(i>=1 && i<=9) {
					zone=0;
				}
				if(i>=0 && i<11 && j==0) {
					zone=1;
				}
				if(i>=0 && i<11 && j==14) {
					zone=1;
				}
				if(j==6 && i==0) {
					zone=0;
				}
				valitedMovement[i][j] = new Map(app, j*60, i*60, 60,zone);
				//System.out.println("zone"+ + zone);
			}
		}
	}

	public void Pintar() {

		app.image(fondo, 0, 0);

		if (isPokedex) {
			pokedexScreen.paint();
		}
		for(int i=0; i<rows;i++) {
			for(int j=0;j<cols;j++) {
			valitedMovement[i][j].paint();	
			}
		}

	}

	public void PintarPersonaje() {

		controllerMain.PintarPersonaje();
	}

	public void MoverPersonaje(int key) {
	
	if(zone==0) {
		controllerMain.MoverPersonaje(key);
		System.out.println(zone);
	}
	
				
				
			
		
		
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
	}

}
