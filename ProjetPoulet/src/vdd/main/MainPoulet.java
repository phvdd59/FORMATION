package vdd.main;

import aaa.viande.Viande;

public class MainPoulet {

	public static void main(String[] args) {
		MainPoulet mainPoulet = new MainPoulet();
		mainPoulet.init();
	}

	public void init() {

		Viande poulet = new Viande();

	}

	
	public void attente(long duree) {
		try {
			Thread.sleep(duree);
		} catch (InterruptedException e) {
		}
	}
}
