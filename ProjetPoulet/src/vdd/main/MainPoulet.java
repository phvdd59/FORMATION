package vdd.main;

import aaa.viande.Four;
import aaa.viande.Viande;
import mapf.feculent.Feculent;
import mapf.feculent.Patate;
import mapf.feculent.PlaquesCuissonsInuduction;

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
