package vdd.metier.produits.aliments;

public class Viande extends Alimentaire implements Volaille {
	
	private boolean bDeplume;
	private boolean bVide;

	public Viande() {
		super();
		bDeplume=false;
	}

	public Viande(String nom, float poids, float prixUnitaire) {
		super(nom, poids, prixUnitaire);
	}

	@Override
	public void deplumer() {
		try {
			Thread.sleep((long) (super.getPoids() * 1000));
		} catch (InterruptedException e) {
		}
		bDeplume=true;
	}

	@Override
	public void vider() {
		try {
			Thread.sleep((long) (super.getPoids() * 500));
		} catch (InterruptedException e) {
		}
		bVide=true;
	}

	@Override
	public boolean estDeplume() {
		return bDeplume;
	}

	@Override
	public boolean estVider() {
		return bVide;
	}
}
