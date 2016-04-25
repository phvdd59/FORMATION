package vdd.metier;

import java.util.ArrayList;

public class ListeExperience extends ArrayList<Experience> {

	private ListeEtudiant listeEtudiant;

	public ListeExperience() {
		listeEtudiant = new ListeEtudiant();
	}

	public ListeEtudiant getListeEtudiant() {
		return listeEtudiant;
	}

	public void setListeEtudiant(ListeEtudiant listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}

}
