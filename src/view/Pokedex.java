package view;

import controller.ControllerJuego;
import model.SortByLevel;
import model.SortByType;
import processing.core.PApplet;
import processing.core.PImage;

public class Pokedex {
	private PApplet app;
	private PImage fondo;
	private ControllerJuego controlador;
	private int listX, listY;
	private String pokemonName;

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
			listX = 600;
			listY = (74*i)+280;
			pokemonName = controlador.listPokemons().get(i).getNombre();
			app.text(pokemonName,listX,listY);
		}
	}
	
	public void mouse() {

		for(int i=0; i<controlador.listPokemons().size();i++) {
			if(PApplet.dist(app.mouseX, app.mouseY, getListX()+15, (74*i)+280)<45) {
				
				if(controlador.listPokemons().get(i).getNombre().contentEquals("Beaplum")) {
					fondo = app.loadImage("./../imagenes/PokedexPlanta.png");
					System.out.println("negris");
						}
				
				if(controlador.listPokemons().get(i).getNombre().contentEquals("Toazel")) {
					fondo = app.loadImage("./../imagenes/PokedexAgua.png");
					System.out.println("negris");
						}
				if(controlador.listPokemons().get(i).getNombre().contentEquals("Ashtile")) {
					fondo = app.loadImage("./../imagenes/PokedexFuego.png");
					System.out.println("negris");
						}
				if(controlador.listPokemons().get(i).getNombre().contentEquals("Greg")) {
					fondo = app.loadImage("./../imagenes/PokedexNormal.png");
					System.out.println("negris");
						}
				
			}
			
		}
			
	}
	
	public void keyBoard(char key) {
		controlador.OrdenPokemon(key);
	}
	
	public boolean closePokedex() {
		if(app.mouseX>650&&app.mouseY>650&&app.mouseX<700&&app.mouseY<700) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * @return the listX
	 */
	public int getListX() {
		return listX;
	}

	/**
	 * @param listX the listX to set
	 */
	public void setListX(int listX) {
		this.listX = listX;
	}

	/**
	 * @return the listY
	 */
	public int getListY() {
		return listY;
	}

	/**
	 * @param listY the listY to set
	 */
	public void setListY(int listY) {
		this.listY = listY;
	}

	/**
	 * @return the pokemonName
	 */
	public String getPokemonName() {
		return pokemonName;
	}

	/**
	 * @param pokemonName the pokemonName to set
	 */
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	
}
