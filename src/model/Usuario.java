package model;

import java.util.LinkedList;

import processing.core.PApplet;

public abstract class Usuario implements Comparable <Usuario> {

	PApplet app;
	String nombre;
	// boolean activo;
	public boolean activo;
	LinkedList<Pokemon> pokemonJugador;
	

	public Usuario(PApplet app, String nombre,boolean activo) {

		this.app = app;
		this.nombre = nombre;
		this.activo=activo;
		pokemonJugador= new LinkedList<Pokemon>();
		
	}

	public LinkedList<Pokemon> getPokemonJugador() {
		return pokemonJugador;
	}

	public void setPokemonJugador(LinkedList<Pokemon> pokemonJugador) {
		this.pokemonJugador = pokemonJugador;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public abstract void Pintar();

	public abstract void Mover(int key);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
