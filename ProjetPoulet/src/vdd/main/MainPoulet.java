package vdd.main;

import vdd.metier.chaud.Chaud;
import vdd.metier.chaud.Plancha;
import vdd.metier.chaud.Plaque;
import vdd.metier.dessert.Fruit;
import vdd.metier.dessert.Gateau;
import vdd.metier.dessert.Pate;

public class MainPoulet {

	public static void main(String[] args) {
		MainPoulet mainPoulet = new MainPoulet();
		mainPoulet.init();
	}

	public void init() {

		//		Personne philippe=new Personne("Philippe");
		//		philippe.init();
		Plaque plaque = new Plaque("Plaque1");
		Fruit fruit = new Fruit("Ananas", 0.5f);
		fruit.nettoyer();
		fruit.decoupe();
		fruit.griller(plaque);

		Chaud plantcha = new Plancha("Plantcha");
		Fruit banane = new Fruit("Banane", 0.5f);
		banane.nettoyer();
		banane.decoupe();
		banane.griller(plantcha);

		Pate pate = new Pate("pate", 0.5f);
		Gateau gateau = new Gateau(fruit, pate, plaque);
		gateau.faireGateau();
	}

	public void attente(long duree) {
		try {
			Thread.sleep(duree);
		} catch (InterruptedException e) {
		}
	}
}
