package aaa.metier;

import java.util.ArrayList;

import sdpc.metierScolaire.ListeEtudiant;

public class ListeCompetence extends ArrayList<Competence> {

	private ListeEtudiant listeEtudiant;

	public ListeCompetence() {
		listeEtudiant = new ListeEtudiant();
	}

	public ListeCompetence(ListeEtudiant listeEtudiant) {
		listeEtudiant = new ListeEtudiant();
	}
}
