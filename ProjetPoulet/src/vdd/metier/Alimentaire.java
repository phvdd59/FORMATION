package vdd.metier;

import java.io.Serializable;

public class Alimentaire extends Produit implements Serializable, Comparable<Produit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float poids;

	public Alimentaire() {
		super();
	}

	public Alimentaire(String nom) {
		super(nom);
	}

	public Alimentaire(String nom, float poids) {
		super(nom);
		this.poids = poids;
	}

	public Alimentaire(String nomSaisi, String poidsOuQteSaisi) {
		super(nomSaisi);
		this.poids = Float.valueOf(poidsOuQteSaisi).floatValue();
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		if (poids >= 0) {
			this.poids = poids;
		} else {
			this.poids = 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Alimentaire) {
			Alimentaire e = (Alimentaire) obj;
			retour = this.getNom().equals(e.getNom());

			retour = true;
		}
		return retour;
	}

	@Override
	public int hashCode() {
		return this.getNom().hashCode();
	}

	@Override
	public int compareTo(Produit p) {
		int retour = 0;
		if (p instanceof Alimentaire) {
			retour = this.getNom().compareTo(p.getNom());
		} else if (p instanceof Consommable) {
			retour = 1;
		}
		return retour;
	}
}
