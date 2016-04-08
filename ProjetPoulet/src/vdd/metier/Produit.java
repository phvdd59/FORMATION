package vdd.metier;

import java.io.Serializable;

public abstract class Produit implements Serializable, Comparable<Produit> {

	public static int CPT;

	private int id;
	private String nom;
	private float prixUnitaire;

	public Produit() {
		id = CPT;
		CPT++;
	}

	public Produit(String nom, float prixUnitaire) {
		id = CPT;
		CPT++;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
	}

	public Produit(String nomSaisi, String prixUnitaireSaisi) {
		id = CPT;
		CPT++;
		prixUnitaire = Float.valueOf(prixUnitaireSaisi).floatValue();
		this.nom = nomSaisi;

	}

	@Override
	public String toString() {
		return getNom() + " : " + getPrix();
	}

	public abstract float getPrix();

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public abstract boolean rajoute(Produit e);

	@Override
	public boolean equals(Object obj) {
		System.out.println(obj.toString());
		return super.equals(obj);
	}

	// @Override
	// public int compareTo(Produit p) {
	// int retour=0;
	// if (p instanceof Consommable) {
	// if (this instanceof Alimentaire) {
	// retour=1;
	// }else if (this instanceof Consommable) {
	// retour= this.getNom().compareTo(p.getNom());
	// }
	// }else if (p instanceof Alimentaire){
	// if (this instanceof Alimentaire) {
	// retour = this.getNom().compareTo(p.getNom());
	// }else if (this instanceof Consommable) {
	// retour= -1;
	// }
	// }
	// return retour;
	// }
	// Finalement on l'a fait dans Consommable et Alimentaire
}