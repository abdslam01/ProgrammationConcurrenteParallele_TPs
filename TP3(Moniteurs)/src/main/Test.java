package main;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<MdseObject> stockInitial = new ArrayList<>();
		for(int i=0; i<7; i++)
			stockInitial.add(new MdseObject(10, 100));
		
		MdseStock mdseStock = new MdseStock(stockInitial, 10);
		Chargeur chargeur = new Chargeur();
		Chariot chariot = new Chariot(300);
		Dechargeur dechargeur = new Dechargeur();
		
		Thread chargeurThread = new Thread(new Runnable() {
			public void run() {
				synchronized(this) {
					while(!mdseStock.stockEstVide()) {
						if(!chargeur.chargerDeStockAChariot(mdseStock, chariot)) {
							System.out.println("chargeurThread Sleeping ...");
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				System.out.println("fin chargeurThread");
			}
		});
		
		Thread dechargeurThread = new Thread(new Runnable() {
			public void run() {
				synchronized(this) {
					while(chargeurThread.getState()!=Thread.State.TERMINATED) {
						if(!dechargeur.dechargerDeChariot(chariot))
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
					}
					while(dechargeur.dechargerDeChariot(chariot));
				}
				System.out.println("fin dechargeurThread");
			}
		});
		
		System.out.println(mdseStock.toString());
		System.out.println(chariot.toString());
		System.out.println();
		
		chargeurThread.start();
		dechargeurThread.start();
		dechargeurThread.join();
		chargeurThread.join();
		
		System.out.println();
		System.out.println(mdseStock.toString());
		System.out.println(chariot.toString());
	}
}
