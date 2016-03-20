package main;

import metier.fabricant.Pompe;
import metier.petrolier.Station;
import metier.vehicule.Vehicule;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}

	private void init() {
		Station stationTotal = new Station();
		stationTotal.cuve = 1000;
		Vehicule v = new Vehicule();
		v.serv = stationTotal;
		v.prendreEscence(5);
		System.out.println(stationTotal.cuve);
		Pompe pompeConcecionnaireRenault = new Pompe();
		pompeConcecionnaireRenault.bidon = 100;
		v.serv = pompeConcecionnaireRenault;
		v.prendreEscence(12);
		System.out.println(pompeConcecionnaireRenault.bidon);
		v.prendreEscence(45, stationTotal);
		v.prendreEscence(23, pompeConcecionnaireRenault);
		System.out.println(stationTotal.cuve + " " + pompeConcecionnaireRenault.bidon);
		v.cout(10, stationTotal);
		v.cout(10, pompeConcecionnaireRenault);
	}
}
