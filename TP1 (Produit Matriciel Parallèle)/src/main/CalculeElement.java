package main;

//Question3
class CalculeElement implements Runnable{
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
	public void run() {
		try {
			m.setElement(i, j, MaMatriceEntiere.produitUneLigneColonne(m1, i, m2, j));
		} catch (TaillesNonConcordantesException e) {
			e.printStackTrace();
		}
		System.out.println("Fin de calcule en position i,j="+i+","+j);
	}
}