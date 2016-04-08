package vdd.metier.produits.aliments;

public class Legume extends Alimentaire implements Apreter {

	public Legume() {
		super();
	}

	public Legume(String nom, float poids, float prixUnitaire) {
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
