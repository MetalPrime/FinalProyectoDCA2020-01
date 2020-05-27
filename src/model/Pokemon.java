package model;

import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("rawtypes")
public class Pokemon implements Comparable<Pokemon>, Runnable {
	private String nombre;
	private int vida;
	private int nivel;
	private int experiencia;
	private int daño;
	private String tipo;
	Map[][] valitedPokemon;
	int cols, rows, zone;
	int posX, posY;
	int inicialX, inicialY;
	private PApplet app;
	private PImage pokemon;
	private int randomMovement;
	private boolean mover;

	public Pokemon(String nombre, int vida, int nivel, int experiencia, int daño, String tipo, PApplet app) {
		this.nombre = nombre;
		this.vida = vida;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.daño = daño;
		this.tipo = tipo;
		zone = 0;
		cols = 15;
		rows = 12;
		inicialX = 2;
		inicialY = 8;
		this.app = app;
		mover = true;

		valitedPokemon = new Map[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0) {
					zone = 1;
				}
				if (i >= 1) {
					zone = 0;
				}

				if (i >= 5) {
					zone = 1;
				}
				if (j >= 0 && j <= 6) {
					zone = 1;
				}
				if (j == 14) {
					zone = 1;
				}

				valitedPokemon[i][j] = new Map(this.app, j * 60, i * 60, 60, zone);
			}
		}

		if (getTipo().contentEquals("Planta")) {
			pokemon = app.loadImage("../imagenes/Pokemones/plantaGrande.png");
		}
		if (getTipo().contentEquals("Agua")) {
			pokemon = app.loadImage("../imagenes/Pokemones/aguaGrande.png");
		}
		if (getTipo().contentEquals("Fuego")) {
			pokemon = app.loadImage("../imagenes/Pokemones/fuegoGrande.png");
		}
		if (getTipo().contentEquals("Normal")) {
			pokemon = app.loadImage("../imagenes/Pokemones/NormalGrande.png");
		}

		posX = 480;
		posY = 120;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			movement();
			LevelUp();
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void PintarPasto() {
		// app.image(pokemon, posX, posY,60,60);
	}

	public void movement() {

		if (mover) {

			if (app.frameCount % 30 == 0) {
				randomMovement = (int) app.random(0, 4);
				// System.out.println(getNombre()+ +inicialX+"..."+inicialY);
			}
			if (randomMovement == 0) {

				if (valitedPokemon[inicialX][inicialY - 1].getType() == 0) {

					posX -= 60;
					inicialY -= 1;
				}

			}

			// Derecha

			if (randomMovement == 1) {

				if (valitedPokemon[inicialX][inicialY + 1].getType() == 0) {

					posX += 60;
					inicialY += 1;
				}

			}

			// Arriba

			if (randomMovement == 2) {

				if (valitedPokemon[inicialX - 1][inicialY].getType() == 0) {

					posY -= 60;
					inicialX -= 1;
				}

			}

			// Abajo

			if (randomMovement == 3) {

				if (valitedPokemon[inicialX + 1][inicialY].getType() == 0) {

					posY += 60;
					inicialX += 1;
				}

			}
		}
	}

	public void LevelUp() {

		if (this.experiencia >= 15) {
			this.nivel = 2;
		}
		


		if (this.experiencia >= 30) {
			this.nivel = 3;
		}
		


		if (this.experiencia >= 45) {
			this.nivel = 3;
		}

	

	

	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
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
	 * @return the daño
	 */
	public int getDaño() {
		return daño;
	}

	/**
	 * @param daño the daño to set
	 */
	public void setDaño(int daño) {
		this.daño = daño;
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
