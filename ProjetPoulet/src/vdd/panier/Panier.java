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

	@Override
	public String toString() {
		return this.nomDuPanier;
	}
}
