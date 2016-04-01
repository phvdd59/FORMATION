package ag.metier.stock;

import java.util.ArrayList;

import ag.metier.produit.Produit;

public class Stock extends ArrayList<Produit> {

	public static int NUM_STOCK = 0;
	private String nom;
	private float mtTotalStock;
	private float limitePrix;

	public Stock() {
		nom = "stock" + Integer.toString(NUM_STOCK);
		setLimitePrix(0);
		NUM_STOCK++;
		mtTotalStock = 0;
	}

	public Stock(String nom) {
		this.nom = nom;
		setLimitePrix(0);
		NUM_STOCK++;
	}

	public Stock(String nom, float limiteprix) {
		this.nom = nom;
		this.setLimitePrix(limitePrix);
		if (limitePrix == 0) {
			this.limitePrix = Float.POSITIVE_INFINITY;
		}
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public static int getNUM_STOCK() {
		return NUM_STOCK;
	}

	public static void setNUM_STOCK(int nUM_STOCK) {
		NUM_STOCK = nUM_STOCK;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getMtTotalStock() {
		return mtTotalStock;
	}

	public void setMtTotalStock(float mtTotalStock) {
		this.mtTotalStock = mtTotalStock;
	}

	public float getLimitePrix() {
		return limitePrix;
	}

	public void setLimitePrix(float limitePrix) {
		this.limitePrix = limitePrix;
	}

	@Override
	public boolean add(Produit e) {
		boolean depassePas = false;
		float somme = e.getPrix() + mtTotalStock;
		if (somme <= limitePrix || limitePrix == 0) {
			if (contains(e)) {
				Produit p = get(indexOf(e));
				p.rajoute(e);
			} else {
				depassePas = super.add(e);
				if (depassePas) {
					mtTotalStock = somme;
				}
			}
		}
		return depassePas;
	}

	public float somme() {
		float somme = 0;
		for (int i = 0; i < this.size(); i++) {
			somme += this.get(i).getPrix();
		}
		return somme;
	}

	@Override
	public String toString() {
		return this.nom;
	}

	@Override
	public Produit remove(int nb) {

		if (nb < 0) {
		} else {
			Produit e = super.get(nb);

			this.setMtTotalStock(this.getMtTotalStock() - e.getPrix());
		}

		return null;
	}

	@Override
	public boolean remove(Object o) {
		boolean moinsProd = false;
		Produit e = (Produit) o;
		moinsProd = super.remove(e);
		if (moinsProd) {
			this.setMtTotalStock(this.getMtTotalStock() - e.getPrix());
		}
		return moinsProd;
	}
}
