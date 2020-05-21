package model;

@SuppressWarnings("rawtypes")
public class Pokemon implements Comparable,Runnable {
	private String nombre;
	private int vida;
	private int nivel;
	private int experiencia;
	private int daño;
	private String tipo;

	public Pokemon (String nombre, int vida,int nivel,int experiencia,int daño,String tipo) {
		this.nombre = nombre;
		this.vida = vida;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.daño = daño;
		this.tipo = tipo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void PintarPokedex() {
		
	}
	
	public void PintarPasto() {
		
	}
	
	public void movement() {
		
	}
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
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



	
	
	
	
}
