package main;

public class RequeteReponse {
	private Client clientEmetteur;
	private int numRequete, resulat;
	
	public RequeteReponse(Client clientEmetteur, int numRequete, int resulat) {
		this.clientEmetteur = clientEmetteur;
		this.numRequete = numRequete;
		this.resulat = resulat;
	}
	
	public Client getClientEmetteur() {
		return clientEmetteur;
	}
	public int getNumRequete() {
		return numRequete;
	}
	public int getResulat() {
		return resulat;
	}

	@Override
	public String toString() {
		return "RequeteReponse [client=" + clientEmetteur.getClientId() + ", numRequete=" + numRequete + ", resulat="
				+ resulat + "]";
	}
	
}
