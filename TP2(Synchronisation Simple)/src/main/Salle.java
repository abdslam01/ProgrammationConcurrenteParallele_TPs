package main;

//Question1
public class Salle {
	public static int placereserve=0;
	protected boolean [][]placesLibres;
	protected int nbRangs, nbPlacesParRang;
	public Salle(int nbRangs, int nbPlacesParRang) {
		this.placesLibres = new boolean[nbRangs][nbPlacesParRang];
		this.nbRangs = nbRangs;
		this.nbPlacesParRang = nbPlacesParRang;
		for(int i=0; i<nbRangs; i++)
			for(int j=0; j<nbPlacesParRang; j++)
				this.placesLibres[i][j] = true;
	}
	
	public int Placedispo() {
		int places=0;
		for(int i=0; i<this.nbRangs; i++)
			for(int j=0; j<this.nbPlacesParRang; j++)
				if(placesLibres[i][j])
					places++;
		return places;
	}
	
	public boolean capaciteOK(int n) {
		return Placedispo() >= n;
	}
	
	public int nContiguesAuRangI(int n, int i) {
		int nplaces=0, j=-1;
		for(int col=nbPlacesParRang; col>-1; col--)
			if(placesLibres[i][col]) {
				nplaces++;
				j=col;
			}
		return nplaces>=n ? j : -1; 
			
	}
	
	public synchronized boolean reserverContigues(int id, int n) {
		int StartColomn = nContiguesAuRangI(n, id);
		if(StartColomn > -1) {
			for(int i=StartColomn; i<StartColomn+n; i++) {
				placesLibres[id][i] = false;
				placereserve++;
			}
			return true;
		}
		return false;
	}
	
	public synchronized boolean reserver(int id, int n) {
		if(reserverContigues(id, n))
			return true;
		else if(capaciteOK(n)) {
			for(int i=0; i<this.nbRangs; i++)
				for(int j=0; j<this.nbPlacesParRang; j++)
					if(placesLibres[i][j]) {
						placesLibres[i][j] = false;
						placereserve++;
						n--;
						if(n==0) return true;
					}
			return true;
		}else
			return false;
	}

//Question2
/**
 * il est nécessaire de garantir l'exclusion mutuelle pour les méthodes "reserverContigues" et 
 *  "reserver", car ces deux méthodes change la nature de tableau "placesLibres".
 *  
 *  On ajoutant le mot clé "synchronized" à leur définition, et l'utilisation d'un sémaphore
 * */
}
