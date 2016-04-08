package vdd.metier.produits.consomable;

public class Plaque extends Consomable implements Chaleur,Associer {

	private Casserole casserole;

	public Plaque() {
		super();
	}

	public Plaque(String nom, int qte, float prixUnitaire) {
		super(nom, qte, prixUnitaire);
	}

	@Override
	public void prechauffer() {
	}

	@Override
	public void cuire() {
	}

	@Override
	public void deposer(Consomable consomable) {
	}

	@Override
	public void enlever(Consomable consomable) {
	}

	@Override
	public boolean estCuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estPreChauffer() {
		// TODO Auto-generated method stub
		return false;
	}
}
