package mfa.sql;

import java.util.ArrayList;

import sdpc.metierScolaire.ListeEtudiant;

public class ListeExperience extends ArrayList<Experience>{
	
	private ListeEtudiant listeEtudiant;
	
	public ListeExperience(){
		listeEtudiant=new ListeEtudiant();
	}

	public ListeEtudiant getListeEtudiant() {
		return listeEtudiant;
	}

	public void setListeEtudiant(ListeEtudiant listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}
	
	

}
