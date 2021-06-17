package main;

//Question3
public class Groupe extends Thread{
	protected int id, nb;
	protected Salle s;
	public Groupe(int id, int nb, Salle s) {
		this.id = id;
		this.nb = nb;
		this.s = s;
	}

	@Override
	public void run() {
		try {
			s.reserver(id, nb);
			System.out.println("la r�servation r�ussite");
		}catch(Exception e) {
			System.err.println("la r�servation �chec");
		}
	}

}
