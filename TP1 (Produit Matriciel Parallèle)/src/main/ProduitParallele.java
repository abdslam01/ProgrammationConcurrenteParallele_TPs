package main;

//Question4
public class ProduitParallele{
	public static void main(String[] args) throws InterruptedException {
		MaMatriceEntiere m1, m2, m;
		m1=new MaMatriceEntiere(3, 3, 1);
		m2=new MaMatriceEntiere(3, 3, 1);
		m=new MaMatriceEntiere(3, 3, 0);
		
		m1.printMatrice();
		m2.printMatrice();
		
		Thread thread;
		for(int i=0; i<m.getNbLignes(); i++) {
			for(int j=0; j<m.getNbColonnes(); j++) {
				thread=new Thread(new CalculeElement(m1, i, m2, j, m));
				thread.start();
				thread.join();
			}
		}
		
		m.printMatrice();
	}
}