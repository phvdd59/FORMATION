package vdd.panier;

import java.util.ArrayList;

import vdd.metier.Produit;

public class Panier extends ArrayList<Produit> {
	public static int NUM_PANIER = 0;

	private String nomDuPanier;

	public Panier() {
		nomDuPanier = "panier" + Integer.toString(NUM_PANIER);
		NUM_PANIER++;
	}

	public Panier(String nomDuStock) {
		this.nomDuPanier = nomDuStock;
		NUM_PANIER++;
	}

	public Panier(String nomDuStock, float limitePrix) {
		this.nomDuPanier = nomDuStock;
		NUM_PANIER++;
	}

	@Override
	public String toString() {
		return this.nomDuPanier;
	}

	public void setLimitePrix(float limitePrix) {
		if (limitePrix < 0) {
		}
	}

	public float calculSomme() {
		float somme = 0;
		for (int i = 0; i < size(); i++) {
			somme += this.get(i).getPrix();
		}
		return somme;
	}
}
