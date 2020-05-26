package model;

import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("rawtypes")
public class Pokemon implements Comparable<Pokemon>,Runnable {
	private String nombre;
	private int vida;
	private int nivel;
	private int experiencia;
	private int da�o;
	private String tipo;
	Map [][] valitedPokemon;
	int cols,rows,zone;
	int posX, posY;
	int inicialX,inicialY;
	private PApplet app;
	private PImage pokemon;

	public Pokemon (String nombre, int vida,int nivel,int experiencia,int da�o,String tipo,PApplet app) {
		this.nombre = nombre;
		this.vida = vida;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.da�o = da�o;
		this.tipo = tipo;
		zone = 0;
		cols=15;
		rows=12;
		inicialX = 1;
		inicialY = 7;
		this.app = app;
		
		valitedPokemon = new Map[rows][cols];
		for(int i=0; i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(i==0) {
					zone=1;
				}
				if(i>=1 ) {
					zone=0;
				}
				
				if(i>=5) {
					zone=1;
				}
				if(j>=0 && j<=6) {
					zone=1;
				}
				if(j==14) {
					zone=1;
				}
				
				
				valitedPokemon[i][j] = new Map(this.app, j*60, i*60, 60,zone);
			}
		}
		
		if(getTipo().contentEquals("Planta")) {
			pokemon = app.loadImage("../imagenes/Pokemones/plantaGrande.png");
		}
		if(getTipo().contentEquals("Agua")) {
			pokemon = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		}
		if(getTipo().contentEquals("Fuego")) {
			pokemon = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		}
		if(getTipo().contentEquals("Normal")) {
			pokemon = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		}
		
		
		posX=420;
		posY=60;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		movement();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void PintarPasto() {
		app.image(pokemon, posX, posY,60,60);
	}
	
	public void movement() {
		
	}
	
	@Override
	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.getNombre());
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * @param experiencia the experiencia to set
	 */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * @return the da�o
	 */
	public int getDa�o() {
		return da�o;
	}

	/**
	 * @param da�o the da�o to set
	 */
	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the zone
	 */
	public int getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(int zone) {
		this.zone = zone;
	}

	/**
	 * @return the posX
	 */
	public final int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public final void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public final int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public final void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the inicialX
	 */
	public int getInicialX() {
		return inicialX;
	}

	/**
	 * @param inicialX the inicialX to set
	 */
	public void setInicialX(int inicialX) {
		this.inicialX = inicialX;
	}

	/**
	 * @return the inicialY
	 */
	public int getInicialY() {
		return inicialY;
	}

	/**
	 * @param inicialY the inicialY to set
	 */
	public void setInicialY(int inicialY) {
		this.inicialY = inicialY;
	}

	



	
	
	
	
}
