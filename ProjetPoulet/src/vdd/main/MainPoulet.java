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

		Viande poulet = new Viande();
		Feculent patate=new Patate();
		Four four=new Four();
		PlaquesCuissonsInuduction plaque=new PlaquesCuissonsInuduction();
		

	}

	
	public void attente(long duree) {
		try {
			Thread.sleep(duree);
		} catch (InterruptedException e) {
		}
	}
}
