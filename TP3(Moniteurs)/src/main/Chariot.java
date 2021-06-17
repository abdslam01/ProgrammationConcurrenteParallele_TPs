package main;

import java.util.ArrayList;

public class Chariot {
	private int poidsMax;
	private ArrayList<MdseObject> stockChariot;
	
	public Chariot(int poidsMax) {
		this.poidsMax=poidsMax;
		stockChariot=new ArrayList<>();
	}
	
	public synchronized boolean ajouterAuChariot(MdseObject mdseObject) {
		if(poidsDeStockChariot()+mdseObject.getPoids() <= poidsMax) {
			stockChariot.add(mdseObject);
			System.out.println(">> Objet Ajoutee "+mdseObject.toString());
			return true;
		}
		System.out.println("Objet "+mdseObject.toString()+" ne peut pas etre ajoutee, chariot plein");
		return false;
	}
	public synchronized boolean supprimerAuChariot() {
		if(poidsDeStockChariot()==0) return false;
		MdseObject m=stockChariot.remove(0);
		System.out.println("<< Objet Depiler "+m.toString());
		return true;
	}
	 
	public int poidsDeStockChariot() {
		int p=0;
		for(MdseObject m: stockChariot)
			p+=m.getPoids();
		return p;
	}
		
	public int getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(int poidsMax) {
		this.poidsMax = poidsMax;
	}

	@Override
	public String toString() {
		return "Chariot " + stockChariot;
	}
}
