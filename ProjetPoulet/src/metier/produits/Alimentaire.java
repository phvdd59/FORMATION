package metier.produits;

import java.io.Serializable;

public class Alimentaire extends Produits implements Serializable, Comparable<Produits> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;// si cgt de parametre alors
	// il faut changer la version de serie
	// a pour vocation de sauvegarder les propriétés
	private float poids;

	public Alimentaire() {
		super();

	}

	public Alimentaire(String nom, float poids, float prixUnitaire) {
		super(nom, prixUnitaire);
		this.poids = poids;

	}

	public Alimentaire(String nom, String poids, String prixUnitaire) {
		super(nom, prixUnitaire);
		this.poids = Float.valueOf(poids).floatValue();
	}

	@Override
	public float getPrix() {
		return getPrixUnitaire() * getPoids();
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		if (poids > 0) {
			this.poids = poids;
		} else {
			this.poids = 0;
		}

	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj instanceof Alimentaire) {
			Alimentaire e = (Alimentaire) obj;
			b = this.getNom().equals(e.getNom());
		}
		return b;
	}

	@Override
	public boolean rajoute(Produits e) {
		boolean ok = false;
		if (e instanceof Alimentaire && e.getNom().equals(this.getNom())) {
			this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getPoids() + ((Alimentaire) e).getPoids()));
			this.setPoids(this.getPoids() + ((Alimentaire) (e)).getPoids());
			ok = true;
		}
		return ok;
	}

	@Override
	public int compareTo(Produits o) {

		return this.getNom().compareTo(o.getNom());
	}

}
