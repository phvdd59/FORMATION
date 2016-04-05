package vdd.metier.produits.consomable;

import vdd.metier.produits.Produit;
import vdd.metier.produits.aliments.Alimentaire;

public class Consomable extends Produit implements Comparable<Produit> {

	private int qte;

	public Consomable() {
		super();
	}

	public Consomable(String nom, int qte, float prixUnitaire) {
		super(nom, prixUnitaire);
		this.qte = qte;
	}

	@Override
	public float getPrix() {
		return getPrixUnitaire() * getQte();
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		if (qte > 0) {
			this.qte = qte;
		} else {
			this.qte = 0;
		}
	}

	@Override
	public boolean rajoute(Produit e) {
		boolean ok=false;
		if (e instanceof Consomable && e.getNom().equals(this.getNom())) {
			Consomable a=(Consomable) e;
			this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getQte() + a.getQte()));
			this.setQte(this.getQte()+a.getQte());
			ok=true;
		}
		return ok;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Consomable) {
			Consomable e = (Consomable) obj;
			retour=this.getNom().equals(e.getNom());
		}
		System.out.println("equals Consomable "+this+" : "+retour);
		return retour;
	}

	@Override
	public int hashCode() {
		return getNom().hashCode();
	}

	@Override
	public int compareTo(Produit p) {
		int retour=0;
		if (p instanceof Consomable) {
			retour = this.getNom().compareTo(p.getNom());
		} else if (p instanceof Alimentaire) {
			retour = -1;
		}
		return retour;
	}
}
