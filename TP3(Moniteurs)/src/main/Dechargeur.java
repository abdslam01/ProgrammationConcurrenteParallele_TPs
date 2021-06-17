package main;

public class Dechargeur {
	public synchronized boolean dechargerDeChariot(Chariot chariot) {
		return chariot.supprimerAuChariot();
	}
}
