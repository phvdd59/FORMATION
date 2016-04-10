package vdd.metier.dessert;

import mapf.feculent.Preparer;
import vdd.metier.Alimentaire;
import vdd.metier.chaud.Chaud;
import vdd.metier.epice.Sucre;

public class Fruit extends Alimentaire implements Preparer, PreparerFruit {
	public static final int ETAT_FRUIT_NATURE = 0x00;
	public static final int ETAT_FRUIT_NETTOYE = 0x01;
	public static final int ETAT_FRUIT_ECRASE = 0x02;
	public static final int ETAT_FRUIT_EPLUCHE = 0x04;
	public static final int ETAT_FRUIT_SUCRE = 0x08;
	public static final int ETAT_FRUIT_DECOUPE = 0x10;
	public static final int ETAT_FRUIT_FLAMBE = 0x20;

	private int etat;
	private boolean occupe;

	public Fruit(String nom, float poids) {
		super(nom, poids);
		etat = ETAT_FRUIT_NATURE;
		occupe = false;
	}

	@Override
	public void ecraser() {
		if ((etat & ETAT_FRUIT_ECRASE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en cours d'écrfasement");
			try {
				Thread.sleep((long) (getPoids() * 2000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_ECRASE;
			System.out.println(getNom() + " ecrasé");
		}
	}

	@Override
	public void sucre(Sucre sucre) {
		if ((etat & ETAT_FRUIT_SUCRE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en train d'être saupoudrée de "+sucre.getNom());
			try {
				Thread.sleep((long) (getPoids() * sucre.getPoids()/10 * 10000));
			} catch (InterruptedException e) {
			}
			sucre.setPoids(sucre.getPoids()*0.9f);
			occupe = false;
			etat = etat | ETAT_FRUIT_SUCRE;
			System.out.println(getNom() + " Sucré avec " + sucre.getNom());
		}
	}

	@Override
	public void decoupe() {
		if ((etat & ETAT_FRUIT_DECOUPE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en cours de découpage");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_DECOUPE;
			System.out.println(getNom() + " découpé");
		}
	}

	@Override
	public void griller(Chaud chaud) {
		if ((etat & ETAT_FRUIT_FLAMBE) == 0) {
			occupe = true;
			System.out.println("En cours de préchauffage");
			chaud.chauffer(10);
			System.out.println(getNom()+" en cours de cuisson");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_FLAMBE;
			System.out.println(getNom()+" Cuit");
		}
	}

	@Override
	public void nettoyer() {
		if ((etat & ETAT_FRUIT_NETTOYE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en cours de néttoyage");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_NETTOYE;
			System.out.println(getNom() + " nétoyé");
		}
	}

	@Override
	public void eplucher() {
		if ((etat & ETAT_FRUIT_EPLUCHE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en cours d'epluchure");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_EPLUCHE;
			System.out.println(getNom() + " Epluché");
		}
	}
}
