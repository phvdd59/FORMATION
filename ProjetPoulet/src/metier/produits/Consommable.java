package metier.produits;

import java.io.Serializable;

public class Consommable extends Produits implements Serializable, Comparable<Produits> {
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

	public Consommable(String nom, String qte, String prixUnitaire) {
		super(nom, prixUnitaire);
		this.qte = Integer.valueOf(qte).intValue();

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
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj instanceof Consommable) {
			Consommable e = (Consommable) obj;
			b = this.getNom().equals(e.getNom());
		}
		return b;
	}

	@Override
	public boolean rajoute(Produits e) {
		boolean ok = false;
		if (e instanceof Consommable && e.getNom().equals(this.getNom())) {
			this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getQte() + ((Consommable) e).getQte()));
			ok = true;
		}
		return ok;
	}

	@Override
	public int compareTo(Produits o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
