package metier.vehicule;

import metier.inter.Prix;
import metier.inter.Serv;

public class Vehicule {

	private double reservoire;
	private double maxReservoire;
	public Serv serv;

	public void prendreEscence(double qte) {

		serv.donnerEssence(qte);
	}

	public void prendreEscence(double qte, Serv serv) {
		serv.donnerEssence(qte);
	}

	public void cout(double qte, Prix prix) {
		System.out.println(" prix="+prix.coute(qte));
	}
}
