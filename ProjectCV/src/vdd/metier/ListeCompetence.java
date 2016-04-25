package vdd.metier;

import java.util.ArrayList;

public class ListeCompetence extends ArrayList<Competence> {

	private ListeEtudiant listeEtudiant;

	public ListeCompetence() {
		listeEtudiant = new ListeEtudiant();
	}

	public ListeCompetence(ListeEtudiant listeEtudiant) {
		listeEtudiant = new ListeEtudiant();
	}
}
