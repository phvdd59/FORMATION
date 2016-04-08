package vdd.metier;

import java.io.Serializable;

public class Consommable extends Produit implements Serializable, Comparable<Produit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int qte;

	public Consommable() {
		super();
	}

	public Consommable(String nom, int qte, float prixUnitaire) {
		super(nom, prixUnitaire);
		this.qte = qte;
	}

	public Consommable(String nomSaisi, String poidsOuQteSaisi, String prixUnitaireSaisi) {
		super(nomSaisi, prixUnitaireSaisi);
		this.qte= Integer.valueOf(poidsOuQteSaisi).intValue(); 

	}

	@Override
	public float getPrix() {
		return getPrixUnitaire() * getQte();

	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		if (qte >= 0) {
			this.qte = qte;
		} else {
			this.qte = 0;
		}

	}

	@Override
	public boolean rajoute(Produit e) {
		boolean ok = false;
		if (e instanceof Consommable && e.getNom().equals(this.getNom())) {
			Consommable a = (Consommable) e;
			this.setPrixUnitaire((this.getPrix() + a.getPrix()) / (this.getQte() + a.getQte()));
			ok = true;
		}
		return ok;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Consommable) {
			Consommable e = (Consommable) obj;
			retour = this.getNom().equals(e.getNom());

			retour = true;
		}
		return retour;
	}

	@Override
	public int hashCode() {
		return getNom().hashCode();
	}

	@Override
	public int compareTo(Produit p) {
		int retour = 0;
		if (p instanceof Consommable) {
			retour = this.getNom().compareTo(p.getNom());
		} else if (p instanceof Alimentaire) {
			retour = -1;
		}
		return retour;
	}

}
