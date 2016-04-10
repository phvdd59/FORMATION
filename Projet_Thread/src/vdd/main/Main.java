package vdd.main;

import vdd.ascenceur.ListeAscenseur;
import vdd.personne.ListePersonne;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	public ListePersonne listePersonne;
	public ListeAscenseur listeAscenseur;
	public Affichage aff;

	public boolean sortie;

	public Main() {
		listePersonne = null;
		listeAscenseur = null;
		sortie = false;
	}

	public void init() {
	}
}
