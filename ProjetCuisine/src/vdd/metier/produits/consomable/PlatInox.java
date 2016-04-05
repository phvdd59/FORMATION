package vdd.metier.produits.consomable;

import java.util.ArrayList;

import vdd.metier.produits.aliments.Alimentaire;

public class PlatInox extends Consomable implements Manipuler, Prepare {

	ArrayList<Alimentaire> list = new ArrayList<Alimentaire>();

	public PlatInox() {
		super();
	}

	public PlatInox(String nom, int qte, float prixUnitaire) {
		super(nom, qte, prixUnitaire);
	}

	@Override
	public void melanger() {
	}

	@Override
	public void repose() {
	}

	@Override
	public void ajouter(Alimentaire aliment) {
		list.add(aliment);
	}

	@Override
	public void retirer(Alimentaire aliment) {
	}
}
