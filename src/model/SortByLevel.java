package model;

import java.util.Comparator;

public class SortByLevel implements Comparator<Pokemon>{


	@Override
	public int compare(Pokemon o1, Pokemon o2) {
		// TODO Auto-generated method stub
		return o1.getNivel()-o2.getNivel();
	}

}
