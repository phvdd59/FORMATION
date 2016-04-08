package vdd.personne;

import aaa.viande.Four;
import aaa.viande.Viande;
import bcsd.legume.Feu;
import bcsd.legume.Legume;
import mapf.feculent.Patate;
import mapf.feculent.PlaquesCuissonsInduction;
import vdd.panier.Panier;

public class Personne {
	public static int NUM_PERSONNE = 0;

	private String nom;
	private Panier panier;

	public Personne(String nom) {
		if (nom != null) {
			this.nom = nom;
		} else {
			nom = "personne" + Integer.valueOf(NUM_PERSONNE);
		}
		panier = new Panier();
		NUM_PERSONNE++;
	}

	public void cuisine() {
		Viande poulet = new Viande();
		Four four = new Four();
		Patate patate = new Patate();
		PlaquesCuissonsInduction plaque = new PlaquesCuissonsInduction();
		Feu feu = new Feu();
		Legume carotte = new Legume();

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
}
