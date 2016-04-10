package vdd.metier.dessert;

import vdd.metier.chaud.Chaud;
import vdd.metier.chaud.Plaque;

public class Gateau {

	public Fruit fruit;
	public Plaque plaque;
	public Pate pate;

	public Chaud chaud;
	public PreparerFruit preparerFruit;
	public PreparerPate preparerPate;

	public Gateau() {
		this.fruit = new Fruit("Fruit", 0);
		this.pate = new Pate("Pate", 0);
		this.plaque = new Plaque("Plaque");
	}

	public Gateau(PreparerFruit fruit, PreparerPate pate, Chaud plaque) {
		this.chaud = plaque;
		this.preparerFruit = fruit;
		this.preparerPate = pate;
	}

	public void faireGateau() {
		fruit.ecraser();
		fruit.decoupe();
		fruit.griller(plaque);
		pate.petrire();
		pate.lever(plaque);
	}

	public void faireTouTypeDeGateau() {
		preparerFruit.ecraser();
		preparerFruit.decoupe();
		preparerFruit.griller(chaud);
		preparerPate.petrire();
		preparerPate.lever(chaud);
	}
}
