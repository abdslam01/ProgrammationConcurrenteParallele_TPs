package main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//Question4
public class ProduitParallele{
	public static final int NB_THREADS = 3;
	
	public static void main(String[] args) throws InterruptedException {
		MaMatriceEntiere m1, m2, m;
		m1=new MaMatriceEntiere(3, 3, 1);
		m2=new MaMatriceEntiere(3, 3, 1);
		m=new MaMatriceEntiere(3, 3, 0);
		
		m1.printMatrice();
		m2.printMatrice();
		
		ExecutorService executorService = Executors.newFixedThreadPool(NB_THREADS);
		for(int i=0; i<m.getNbLignes(); i++) {
			for(int j=0; j<m.getNbColonnes(); j++) {
				Future<Integer> calcValue = executorService.submit(new CalculeElement(m1, i, m2, j, m));
				try {
					m.setElement(i, j, calcValue.get());
				} catch (InterruptedException | ExecutionException e) {
					System.err.println(
							String.format("Future de position (%d,%d) est annulé", i, j)
					);
				}
			}
		}
		
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);

		m.printMatrice();
	}
}