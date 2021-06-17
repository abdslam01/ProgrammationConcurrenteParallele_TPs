package main;

public class Chargeur {
	public synchronized boolean chargerDeStockAChariot(MdseStock mdseStock, Chariot chariot) {
		try {
			chariot.ajouterAuChariot(mdseStock.popFromStock());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
