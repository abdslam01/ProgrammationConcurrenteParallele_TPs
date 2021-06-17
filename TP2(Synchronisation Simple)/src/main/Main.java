package main;

//Question4
public class Main {
	public static void main(String []args) {
		Groupe []groupes = new Groupe[5];
		for(int i=0; i<5; i++) {
			groupes[i] = new Groupe(i, i > 2 ? i-1: 1, new Salle(i*2, i*i));
			groupes[i].start();
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("----------\n"
					+ "Taille de la salle: (" + groupes[i].s.nbRangs + ","
					+ groupes[i].s.nbPlacesParRang + ")"
					+ "\nNombre de places réservées: " + Salle.placereserve
					+ "\nNombre de places encore disponibles dans la salle: "
					+ (groupes[i].s.nbPlacesParRang * groupes[i].s.nbRangs - Salle.placereserve)
					+ "\nNombre total des membres des groupes: "
					+ groupes[i].nb);
		}
	}
}
