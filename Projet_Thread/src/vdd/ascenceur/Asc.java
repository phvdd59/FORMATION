package vdd.ascenceur;

import vdd.main.Main;
import vdd.personne.Personne;

public class Asc extends Thread {

	public static int CPT = 0;
	public static long TEMPS = 10;
	public static int HAUTEUR_ETAGE=30;

	public int etage;
	public int progression;
	public boolean fin;
	public Main manageur;
	public Personne personne;

	public Asc(Main manageur) {
		super(Integer.toString(CPT));
		this.manageur = manageur;
		etage = 0;
		progression = 0;
		fin = false;
		personne = null;
		CPT++;
	}

	public String toString() {
		return getName() + " etage :" + etage + " pas :" + progression;
	}
}
