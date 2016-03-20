package metier.petrolier;

import metier.inter.Prix;
import metier.inter.Serv;

public class Station implements Serv,Prix {

	public double cuve;
	public double prixAuLitre=1.2;

	@Override
	public double donnerEssence(double qte) {
		cuve-=qte;
		return qte;
	}

	@Override
	public double coute(double qte) {
		return qte*prixAuLitre;
	}
}
