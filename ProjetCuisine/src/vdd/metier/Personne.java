package vdd.metier;

import vdd.metier.panier.Stock;
import vdd.metier.produits.aliments.Volaille;

public class Personne extends Thread {

	private String etat;
	private Stock panier;

	public Personne() {
		etat = "Libre";
	}
	
	public Personne(Stock panier){
		etat = "Libre";
		this.panier=panier;
	}

	@Override
	public void run() {

	}

	public void deplumer(Volaille v) {
		v.seFaireDeplumer();
	}

	public void vider(Volaille v) {
		v.seFaireVider();
	}
}
