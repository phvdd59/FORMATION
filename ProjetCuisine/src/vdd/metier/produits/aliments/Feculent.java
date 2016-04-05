package vdd.metier.produits.aliments;

public class Feculent extends Alimentaire implements Apreter {

	public Feculent() {
		super();
	}

	public Feculent(String nom, float poids, float prixUnitaire) {
		super(nom, poids, prixUnitaire);
	}

	@Override
	public void netoyer() {
	}

	@Override
	public void eplucher() {
	}

	@Override
	public void decouper() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ecraser() {
		// TODO Auto-generated method stub
		
	}
}
