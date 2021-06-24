package main;

public class Client implements Runnable{
	private int clientId;
	private int nbRequetes;
	private Serveur serveur;
	
	public static Object ActiveClientsObject = new Object();
	public static int nbActiveClients = 0;
	
	public Client(int clientId, int nbRequetes, Serveur serveur) {
		if(nbRequetes <= 0)
			throw new IllegalArgumentException("le nombre de requêtes doit etre strictement positive");
		this.clientId = clientId;
		this.nbRequetes = nbRequetes;
		this.serveur = serveur;
		synchronized(ActiveClientsObject) {
			nbActiveClients++;
		}
	}
	
	@Override
	public void run() {
		trace("Client >> Client " + clientId + " initialisé!");
		
		for(int i = 0; i < nbRequetes; i++) {
			synchronized(this){
				serveur.soumettre(new Requete(this, i+1, 1));
				trace("Client >> Req " +(i+1)+ " du client " +clientId+ " a ete envoyee au serveur");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(serveur.getRequetesEnAttente().isEmpty() && nbActiveClients==1) {
					serveur.interrupt();
				}
			}
		}
		synchronized(ActiveClientsObject) {
			nbActiveClients--;
		}
	}
	
	public synchronized void requeteServie(RequeteReponse requeteReponse) {
		synchronized(this) {
			requeteReponse.getClientEmetteur().notify();
		}
	}
	
	public void trace(String string) {
		System.out.println(string);
		Thread.yield();
	}
	public int getClientId() {
		return clientId;
	}
	
	public int getNbRequetes() {
		return nbRequetes;
	}
	
	public Serveur getServeur() {
		return serveur;
	}
	
}
