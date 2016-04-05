package vdd.metier.produits.consomable;

import java.util.ArrayList;

import vdd.metier.produits.aliments.Alimentaire;

public class Plat extends Consomable implements Manipuler, Prepare {

	ArrayList<Alimentaire> list = new ArrayList<Alimentaire>();

	@Override
	public void melanger() {
	}

	@Override
	public void repose() {
	}

	@Override
	public void ajouter(Alimentaire aliment) {
	}

	@Override
	public void retirer(Alimentaire aliment) {
	}
}
