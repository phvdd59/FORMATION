package vdd.metier.produits.consomable;

import vdd.metier.produits.aliments.Alimentaire;

public interface Manipuler {

	public void ajouter(Alimentaire aliment);
	public void retirer(Alimentaire aliment);

}
