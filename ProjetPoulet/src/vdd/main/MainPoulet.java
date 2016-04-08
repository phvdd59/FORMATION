package vdd.main;

import vdd.personne.Personne;

public class MainPoulet {

	public static void main(String[] args) {
		MainPoulet mainPoulet = new MainPoulet();
		mainPoulet.init();
	}

	public void init() {

		Personne philippe=new Personne("Philippe");
		philippe.cuisine();

	}

	
	public void attente(long duree) {
		try {
			Thread.sleep(duree);
		} catch (InterruptedException e) {
		}
	}
}
