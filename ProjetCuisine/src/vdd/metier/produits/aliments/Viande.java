package vdd.metier.produits.aliments;

public class Viande extends Alimentaire implements Volaille {
	
	private boolean encours;
	private String etat;

	public Viande() {
		super();
		etat = "INIT";
		encours=false;
	}

	public Viande(String nom, float poids, float prixUnitaire) {
		super(nom, poids, prixUnitaire);
	}

	@Override
	public void seFaireDeplumer() {
		etat="Perd ses plumes";
		try {
			Thread.sleep((long) (super.getPoids() * 1000));
		} catch (InterruptedException e) {
		}
		etat="deplum�";
	}

	@Override
	public void seFaireVider() {
		etat="se vide";
		try {
			Thread.sleep((long) (super.getPoids() * 500));
		} catch (InterruptedException e) {
		}
		etat="vid�";
	}

	@Override
	public boolean estDeplume() {
		return etat.equals("deplum�");
	}

	@Override
	public boolean estVider() {
		return etat.equals("vid�");
	}

	public boolean isEncours() {
		return encours;
	}

	public void setEncours(boolean encours) {
		this.encours = encours;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
