package main;

public class Main {
	protected static int NB_CLIENTS = 5;
	
	public static void main(String[] args) throws InterruptedException {
		Serveur serveur =  new Serveur(3);
		serveur.start();
		
		for(int i = 0; i < NB_CLIENTS; i++) {
			new Thread(new Client(i+1, 1, serveur)).start();
		}
		
		System.out.println("Main >> Tous les threads sont lancés");
				
	}

}