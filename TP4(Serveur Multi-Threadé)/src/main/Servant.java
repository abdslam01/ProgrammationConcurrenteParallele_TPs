package main;

import java.util.Random;

public class Servant extends Thread{
	private Requete requete;
	private Random random = new Random();
	
	public Servant(Requete requete) {
		this.requete = requete;
	}
	
	@Override
	public void run() {
		synchronized(this) {
			try {
				if(requete.getClientEmetteur().getClientId()%3 != 0) {
					//Requete de Type 1
					wait(random.nextInt(100));
				}else {
					//Requete de Type 2
					//wait();
				}
				RequeteReponse requeteResponse = new RequeteReponse(requete.getClientEmetteur(),
						requete.getNumRequete(), random.nextInt(1000));
				trace(requeteResponse.toString() + " :je prévien le client");
				requete.getClientEmetteur().requeteServie(requeteResponse);
			}catch(InterruptedException e) {
				System.err.println("Error: Servant - " + e);
			}
		}
	}
	
	public void trace(String string) {
		System.out.println(string);
		Thread.yield();
	}
	
}
