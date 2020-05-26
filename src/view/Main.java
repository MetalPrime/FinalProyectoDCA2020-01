package view;

import javax.naming.NoInitialContextException;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}

	PantallaJuego pantallajuego;
	PantallaInicio pantallainicio;
	PantallaUsuarios pantallaUsuarios;
	boolean pantallausuarios;
	boolean mover;
	int pantalla;

	public void settings() {

		size(901, 720);
	}

	public void setup() {

		pantallajuego = new PantallaJuego(this);
		pantallainicio = new PantallaInicio(this);
		pantallaUsuarios = new PantallaUsuarios(this);
		pantalla = 0;
		mover = false;
		frameRate(10);
	}

	public void draw() {

		switch (pantalla) {
		case 0:
			pantallainicio.Pintar();

			if (pantallausuarios) {
				pantallaUsuarios.Pintar();
			}
			break;
		case 1:

			pantallajuego.Pintar();
			pantallajuego.PintarPersonaje();

			break;

		default:
			break;
		}

	}

	public void mousePressed() {

		// pantalla = 1;

		if (pantalla == 0) {
			
			if (pantallainicio.cambio == true) {
				
				int valor = -1;
				
				if (mouseX > 99 && mouseX < 99 + 173 && mouseY > 169
						&& mouseY < 169 + 194) {
					valor = 0;
					pantallainicio.SeleccionPokemon(valor);
					System.out.println("fuego");
				}

				if (mouseX > 605 && mouseX < 605 + 170 && mouseY > 190
						&& mouseY < 190 + 170) {
					valor = 1;
					pantallainicio.SeleccionPokemon(valor);
				}

				if (mouseX > 360 && mouseX < 360 + 176 && mouseY > 180
						&& mouseY < 180 + 173) {
					valor = 2;
					pantallainicio.SeleccionPokemon(valor);
				}
				
				
				if(valor == -1) {
					try {
						throw new NoInitialContextException("Nel mi Perro, Tiene que seleccionar un pokemon");
					} catch (NoInitialContextException e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					
				} else {
					pantalla=1;
				}
				
				

			}

			else {

				if (mouseX > 329 && mouseX < 329+239 && mouseY >558
						&& mouseY <558+43) {
					pantallainicio.Registrarse();
					// pantalla = 1;
				}

				else if (mouseX > width / 2 && mouseX < width / 2 + 100 && mouseY > height / 2 + 20
						&& mouseY < height / 2 + 140) {

					pantallausuarios = true;

				}
			}
		}
		if (pantalla == 1) {
			pantallajuego.mouse();
			
		}
	}

	public void keyPressed() {

		if (pantalla == 1) {
			pantallajuego.MoverPersonaje(keyCode);
		}
		
		pantallajuego.key(key);

	}

	public void keyReleased() {

		if (pantalla == 1) {
			pantallajuego.Detener();
		}

	}

}
