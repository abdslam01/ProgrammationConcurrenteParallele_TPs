package main;

import java.util.Random;

public class MdseObject {
	private int poids;
	
	public MdseObject(int min, int max) {
		poids=new Random().nextInt(max-min+1) + min;
	}
	
	public int getPoids() {
		return poids;
	}
	
	@Override
	public String toString() {
		return "Obj(" + poids + ")";
	}
}
