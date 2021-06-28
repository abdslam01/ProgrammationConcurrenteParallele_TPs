package main;

import java.util.concurrent.Callable;

class CalculeElement implements Callable<Integer>{
	MaMatriceEntiere m1, m2, m;
	int i, j;
	CalculeElement(MaMatriceEntiere m1, int i, MaMatriceEntiere m2, int j, MaMatriceEntiere m){
		this.m1=m1;
		this.i=i;
		this.m2=m2;
		this.j=j;
		this.m=m;
	}

	@Override
	public Integer call() throws Exception {
		int result = -1; // on cas d'erreur -1 est envoyée
		try {
			result = MaMatriceEntiere.produitUneLigneColonne(m1, i, m2, j);
			System.out.println("Fin de calcule en position i,j="+i+","+j);
		} catch (TaillesNonConcordantesException e) {
			e.printStackTrace();
		}
		return result;
	}
}