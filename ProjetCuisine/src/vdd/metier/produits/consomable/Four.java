package vdd.metier.produits.consomable;

import java.util.ArrayList;

import vdd.metier.produits.Produit;
import vdd.metier.produits.aliments.Alimentaire;

public class Four extends Consomable implements Chaleur,Associer {
	public static int ETAT_FOUR_FROID = 0;
	public static int ETAT_FOUR_EN_CHAUFFE = 1;
	public static int ETAT_FOUR_CHAUD = 2;

	private int degre;
	private int etat;

	private ArrayList<Produit> list;

	public Four() {
		super();
		list = new ArrayList<Produit>();
	}

	public Four(String nom, int qte, float prixUnitaire) {
		super(nom, qte, prixUnitaire);
		list = new ArrayList<Produit>();
	}

	@Override
	public void prechauffer() {
	}

	@Override
	public void cuire() {
	}

	@Override
	public void deposer(Consomable consomable) {
	}

	@Override
	public void enlever(Consomable consomable) {
	}

	@Override
	public boolean estCuit() {
		return false;
	}

	@Override
	public boolean estPreChauffer() {
		return false;
	}
}
