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
			System.out.println(getNom()+" en cours d'�crfasement");
			try {
				Thread.sleep((long) (getPoids() * 2000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_ECRASE;
			System.out.println(getNom() + " ecras�");
		}
	}

	@Override
	public void sucre(Sucre sucre) {
		if ((etat & ETAT_FRUIT_SUCRE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en train d'�tre saupoudr�e de "+sucre.getNom());
			try {
				Thread.sleep((long) (getPoids() * sucre.getPoids()/10 * 10000));
			} catch (InterruptedException e) {
			}
			sucre.setPoids(sucre.getPoids()*0.9f);
			occupe = false;
			etat = etat | ETAT_FRUIT_SUCRE;
			System.out.println(getNom() + " Sucr� avec " + sucre.getNom());
		}
	}

	@Override
	public void decoupe() {
		if ((etat & ETAT_FRUIT_DECOUPE) == 0) {
			occupe = true;
			System.out.println(getNom()+" en cours de d�coupage");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_DECOUPE;
			System.out.println(getNom() + " d�coup�");
		}
	}

	@Override
	public void griller(Chaud chaud) {
		if ((etat & ETAT_FRUIT_FLAMBE) == 0) {
			occupe = true;
			System.out.println("En cours de pr�chauffage");
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
			System.out.println(getNom()+" en cours de n�ttoyage");
			try {
				Thread.sleep((long) (getPoids() * 10000));
			} catch (InterruptedException e) {
			}
			occupe = false;
			etat = etat | ETAT_FRUIT_NETTOYE;
			System.out.println(getNom() + " n�toy�");
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
			System.out.println(getNom() + " Epluch�");
		}
	}
}
