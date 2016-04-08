package vdd.metier.produits.consomable;

import java.util.ArrayList;

import vdd.metier.produits.aliments.Alimentaire;

public class Casserole extends Consomable implements Manipuler,Chaleur {

	private ArrayList<Alimentaire> list;

	public Casserole() {
		super();
		list = new ArrayList<Alimentaire>();
	}

	public Casserole(String nom, int qte, float prixUnitaire) {
		super(nom, qte, prixUnitaire);
		list = new ArrayList<Alimentaire>();
	}

	@Override
	public void ajouter(Alimentaire aliment) {
		list.add(aliment);
	}

	@Override
	public void retirer(Alimentaire aliment) {
		list.remove(aliment);

	}

	@Override
	public void prechauffer() {
	}

	@Override
	public void cuire() {
	}

	@Override
	public boolean estCuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estPreChauffer() {
		// TODO Auto-generated method stub
		return false;
	}
}
