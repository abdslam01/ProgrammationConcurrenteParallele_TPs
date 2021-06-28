package main;

public class MaMatriceEntiere {
	//Question 1
	protected int matrice[][], lignes, colonnes;
	MaMatriceEntiere(int lignes, int colonnes, int p){
		matrice = new int[lignes][colonnes];
		this.lignes=lignes;
		this.colonnes=colonnes;
		if(p==1) {
			int min=0, max=50;
			for(int i=0; i<lignes; i++)
				for(int j=0; j<colonnes; j++)
					matrice[i][j]=min+(int)(Math.random()*(max-min));
		}else if(p==0) {
			for(int i=0; i<lignes; i++)
				for(int j=0; j<colonnes; j++)
					matrice[i][j]=0;
		}
	}
	public int getElement(int i, int j) {
		try {
			return matrice[i][j];
		}catch(Exception e) {
			System.err.println("pas d'element en "+i+", "+j);
			return 0;
		}
	}
	public void setElement(int i, int j, int val) {
		try {
			matrice[i][j]=val;
		}catch(Exception e) {
			System.err.println("pas d'element en "+i+", "+j);
		}
	}
	
	//Question2
	public int getNbLignes() {
		return this.lignes;
	}
	public int getNbColonnes() {
		return this.colonnes;
	}
	public void printMatrice() {
		System.out.println("-----print matrice:-----");
		for(int i=0; i<lignes; i++) {
			for(int j=0; j<colonnes; j++) {
				System.out.print(matrice[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int produitUneLigneColonne(MaMatriceEntiere m1, int i, MaMatriceEntiere m2, int j)
			throws TaillesNonConcordantesException {
		if(m1.getNbLignes()!=m2.getNbColonnes())
			throw new TaillesNonConcordantesException("nb lignes de 1ere matrice est different de nb colonnes de 2eme matrice");
		int value=0;
		for(int counter=0; counter<m1.getNbLignes(); counter++)
			value+=m1.getElement(i,counter)+m2.getElement(counter, j);
		return value;
	}
}