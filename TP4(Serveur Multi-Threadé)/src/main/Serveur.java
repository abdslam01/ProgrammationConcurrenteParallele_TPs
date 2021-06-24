package main;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Serveur extends Thread{
	private ArrayBlockingQueue<Requete> requetesEnAttente;
	private Random random = new Random();
	
	Serveur(int tailQueueAttente){
		if(tailQueueAttente <= 0)
			throw new IllegalArgumentException("la taille de fille d'attente doit etre strictement positive");
		requetesEnAttente = new ArrayBlockingQueue<>(tailQueueAttente);
	}
	@Override
	public void run() {
		trace("Serveur >> initialisé!");
		try {
			while(true)
				traiterRequete();
		}catch(InterruptedException e) {
			trace("Serveur interrompu!");
		}
	}
	
	public void soumettre(Requete requete) {
		trace("Serveur >> je prends la req de " + requete.getClientEmetteur().getClientId());
		try {
			requetesEnAttente.put(requete);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void traiterRequete() throws InterruptedException {
		synchronized(this) {
			if(!requetesEnAttente.isEmpty()) {
				Requete requeteCourante = requetesEnAttente.take();
				/* Pour crée un Thread pour chaque requête reçue par le serveur. */
//				Servant servant = new Servant(requeteCourante);
//				servant.start();
				/* Fin */
				
				/* Pour que le Thread courant traiter les requêtes reçues par le serveur. */
				if(requeteCourante.getClientEmetteur().getClientId()%3 != 0) {
					//Requete de Type 1
					wait(random.nextInt(100));
				}else {
					//Requete de Type 2
					//wait();
				}	
				RequeteReponse requeteResponse = new RequeteReponse(requeteCourante.getClientEmetteur(),
						requeteCourante.getNumRequete(), random.nextInt(1000));
				trace(requeteResponse.toString() + " :je prévien le client");
				requeteCourante.getClientEmetteur().requeteServie(requeteResponse);
				/* Fin */
			}
			if(interrupted()) {
				System.out.println("<>> un Client demande d'interrompu le serveur.");
				wait(random.nextInt(500));
				if(requetesEnAttente.isEmpty())
					throw new InterruptedException();
			}
		}
	}

	public void trace(String string) {
		System.out.println(string);
		Thread.yield();
	}
	
	public ArrayBlockingQueue<Requete> getRequetesEnAttente() {
		return requetesEnAttente;
	}
	
}
