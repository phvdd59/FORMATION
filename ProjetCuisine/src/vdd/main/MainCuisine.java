package vdd.main;

import vdd.metier.Personne;
import vdd.metier.panier.Stock;
import vdd.metier.produits.aliments.Feculent;
import vdd.metier.produits.aliments.Legume;
import vdd.metier.produits.aliments.Viande;
import vdd.metier.produits.aliments.Volaille;
import vdd.metier.produits.consomable.Casserole;
import vdd.metier.produits.consomable.Four;
import vdd.metier.produits.consomable.Plaque;
import vdd.metier.produits.consomable.PlatInox;

public class MainCuisine {

	public static void main(String[] args) {
		MainCuisine m = new MainCuisine();
		m.recette();
	}

	public void recette() {
		Viande poulet = new Viande("Poulet", 1.2f, 5.3f);
		Feculent patate = new Feculent("Patate", 1f, 2.8f);
		Legume carrote = new Legume("Carrote", 0.8f, 1.7f);
		Casserole casserole1 = new Casserole("Casserole1", 1, 5f);
		Casserole casserole2 = new Casserole("Casserole2", 1, 5f);
		Four four = new Four("Four", 1, 300f);
		Plaque plaque1 = new Plaque("Plaque1", 1, 35f);
		Plaque plaque2 = new Plaque("Plaque2", 1, 35f);
		PlatInox platInox = new PlatInox("PlaInox", 1, 23f);
		Stock panier=new Stock();
		panier.add(poulet);
		
		Personne p1 = new Personne(panier);
		Personne p2 = new Personne(panier);
		
		if (poulet.getEtat().equals("INIT")) {
			
		}
		p1.deplumer(poulet);
		p1.vider(poulet);
		platInox.ajouter(poulet);
		patate.eplucher();
		patate.netoyer();
		patate.decouper();
		carrote.netoyer();
		carrote.decouper();
		casserole1.ajouter(carrote);
		casserole1.cuire();
		casserole2.ajouter(patate);
		casserole2.cuire();
		four.prechauffer();
		four.deposer(platInox);
		four.cuire();
	}
}
