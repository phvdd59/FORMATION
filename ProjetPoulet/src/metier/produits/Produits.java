package metier.produits;

import java.io.Serializable;

public abstract class Produits implements Serializable, Comparable<Produits> {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public static int CPT = 0;// créer une fois et accessible partout au travers
								// du nom de la classe
	private String nom;
	private float prixUnitaire;
	private int id;

	public Produits() {
		id = Produits.CPT;
		CPT++;

	}

	public Produits(String nom, float prixUnitaire) {
		id = Produits.CPT;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		CPT++;

	}

	public Produits(String nom, String prixUnitaire) {
		id = Produits.CPT;
		CPT++;
		this.nom = nom;
		this.prixUnitaire = Float.valueOf(prixUnitaire).floatValue();
		// value of rend un string en Float et le float value en nombre float
		// type primitif
	}

	public abstract float getPrix();

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
		if (prixUnitaire > 0) {
			this.prixUnitaire = prixUnitaire;
		} else {
			System.out.println("erreur de prix");
		}

	}

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	@Override
	public String toString() {

		return getNom() + " : " + getPrix() + " €";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract boolean rajoute(Produits e);

}
