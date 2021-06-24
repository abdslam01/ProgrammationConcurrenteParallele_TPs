package main;

public class Requete {
	private Client clientEmetteur;
	private int numRequete, typeTraintement;
	
	
	public Requete(Client clientEmetteur, int numRequete, int typeTraintement) {
		this.clientEmetteur = clientEmetteur;
		this.numRequete = numRequete;
		this.typeTraintement = typeTraintement;
	}
	public Client getClientEmetteur() {
		return clientEmetteur;
	}
	public int getNumRequete() {
		return numRequete;
	}
	public int getTypeTraintement() {
		return typeTraintement;
	}
	
}