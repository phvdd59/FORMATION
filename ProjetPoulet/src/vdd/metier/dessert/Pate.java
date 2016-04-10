package vdd.metier.dessert;

import vdd.metier.Alimentaire;
import vdd.metier.chaud.Chaud;

public class Pate extends Alimentaire implements PreparerPate {
	public static final int ETAT_PATE_NATURE = 0x00;
	public static final int ETAT_PATE_NETTOYE = 0x01;
	public static final int ETAT_PATE_PETRIRE = 0x02;
	public static final int ETAT_PATE_LEVER = 0x04;

	private int etat;
	private boolean occupe;

	public Pate(String nom, float poids) {
		super(nom, poids);
		etat = ETAT_PATE_NATURE;
		occupe = false;
	}

	@Override
	public void petrire() {
		if ((etat & ETAT_PATE_PETRIRE) == 0) {
			occupe = true;
			System.out.println(getNom() + " en cours de pétrissage");
			try {
				Thread.sleep((long) (getPoids() * 2000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_PATE_PETRIRE;
			System.out.println(getNom() + " pétrie");
		}
	}

	@Override
	public void lever(Chaud chaud) {
		if ((etat & ETAT_PATE_LEVER) == 0) {
			occupe = true;
			System.out.println("En cours de préchauffage");
			chaud.chauffer(10);
			System.out.println(getNom() + " en cours de cuisson");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_PATE_LEVER;
			System.out.println(getNom() + " cuite");
		}
	}
}
