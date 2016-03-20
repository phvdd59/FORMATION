package metier.fabricant;

import metier.inter.Prix;
import metier.inter.Serv;

public class Pompe extends Concessionnaire implements Serv,Prix {

	public double bidon;
	private double prix=1.5;
	
	@Override
	public double donnerEssence(double qte) {
		bidon-=qte;
		return bidon;
	}

	@Override
	public double coute(double qte) {
		return prix*qte+3;
	}

}
