package vdd.personne;

import vdd.metier.Produit;
import vdd.metier.chaud.Plaque;
import vdd.metier.dessert.Fruit;
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

	public void init() {
		Plaque plaque = new Plaque("Plaque1");
		Fruit banane = new Fruit("Banane", 0.5f);
		banane.nettoyer();
		banane.eplucher();
		banane.decoupe();
		banane.griller(plaque);
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

	public void add(Produit p) {
		panier.add(p);
	}
}
