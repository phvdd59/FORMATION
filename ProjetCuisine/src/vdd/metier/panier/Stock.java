package vdd.metier.panier;

import java.util.ArrayList;

import vdd.metier.produits.Alimentaire;
import vdd.metier.produits.Consomable;
import vdd.metier.produits.Produit;

public class Stock extends ArrayList<Produit> {
	public static int NUM_STOCK = 0;

	private String nomDuStock;
	private float limitePrix;
	private float mtTotalStock;

	public Stock() {
		nomDuStock = "stock" + Integer.toString(NUM_STOCK);
		limitePrix = 100f;
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public Stock(String nomDuStock) {
		this.nomDuStock = nomDuStock;
		limitePrix = 100;
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public Stock(float limitePrix) {
		nomDuStock = "stock" + Integer.toString(NUM_STOCK);
		setLimitePrix(limitePrix);
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public Stock(String nomDuStock, float limitePrix) {
		this.nomDuStock = nomDuStock;
		this.limitePrix = limitePrix;
		mtTotalStock = 0;
		NUM_STOCK++;
	}

	public String getNomDuStock() {
		return nomDuStock;
	}

	public void setNomDuStock(String nomDuStock) {
		this.nomDuStock = nomDuStock;
	}

	@Override
	public String toString() {
		return this.nomDuStock;
	}

	public float getLimitePrix() {
		return limitePrix;
	}

	public void setLimitePrix(float limitePrix) {
		if (limitePrix < 0) {
			this.limitePrix = limitePrix;
		}
	}

	public float calculSomme() {
		float somme = 0;
		for (int i = 0; i < size(); i++) {
			somme += this.get(i).getPrix();
		}
		return somme;
	}

	@Override
	public void add(int index, Produit element) {
		float somme = mtTotalStock + element.getPrix();
		if (somme <= limitePrix || limitePrix == 0) {
			super.add(index, element);
			mtTotalStock = somme;
		}
	}

	@Override
	public boolean add(Produit e) {
		boolean depassePas = false;
		float somme = mtTotalStock + e.getPrix();
		Stock s = new Stock();
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

	public boolean addOld(Produit e) {
		boolean depassePas = false;
		float somme = mtTotalStock + e.getPrix();
		if (somme <= limitePrix || limitePrix == 0) {
			Produit produitExiste = rechercherProduit(e);
			if (produitExiste != null) {
				depassePas = produitExiste.rajoute(e);
			} else {
				depassePas = super.add(e);
				if (depassePas) {
					mtTotalStock = somme;
				}
			}
		}
		return depassePas;
	}

	public float getMtTotalStock() {
		return mtTotalStock;
	}

	public void setMtTotalStock(float mtTotalStock) {
		this.mtTotalStock = mtTotalStock;
	}

	@Override
	public Produit remove(int index) {
		// TODO Auto-generated method stub

		Produit e = super.get(index);
		this.mtTotalStock -= e.getPrix();

		return super.remove(index);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		Produit e = (Produit) o;
		this.setMtTotalStock(this.getMtTotalStock() - e.getPrix());
		return super.remove(o);
	}

	//	@Override
	//	public boolean contains(Object o) {
	//		boolean bool = false;
	//		if (o instanceof Produit) {
	//			if (indexOf((Produit) o) >= 0) {
	//				bool = true;
	//			}
	//		}
	//		return bool;
	//	}

	//	@Override
	//	public int indexOf(Object o) {
	//		int index = -1;
	//		if (o instanceof Produit) {
	//			index = this.indexOf((Produit) o);
	//		}
	//		return index;
	//	}

	private int indexOf(Produit e) {
		int indiceTrouve = -1;
		for (int i = 0; i < size(); i++) {
			Produit produit = get(i);
			if (produit.getNom().equals(e.getNom())) {
				if (produit instanceof Alimentaire && e instanceof Alimentaire || //
						produit instanceof Consomable && e instanceof Consomable) {
					indiceTrouve = i;
					break;
				}
			}
		}
		return indiceTrouve;
	}

	private Produit rechercherProduit(Produit e) {
		Produit produitTrouve = null;
		for (Produit produit : this) {
			if (produit.getNom().equals(e.getNom())) {
				if (produit instanceof Alimentaire && e instanceof Alimentaire || //
						produit instanceof Consomable && e instanceof Consomable) {
					produitTrouve = produit;
					break;
				}
			}
		}
		return produitTrouve;
	}
}
