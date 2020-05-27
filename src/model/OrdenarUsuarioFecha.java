package model;

import java.util.Comparator;

public class OrdenarUsuarioFecha implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
		// TODO Auto-generated method stub
		return o1.getFecha().compareTo(o2.getFecha());
	}

		

}
