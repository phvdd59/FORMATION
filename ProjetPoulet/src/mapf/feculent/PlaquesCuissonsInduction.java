package mapf.feculent;

import vdd.metier.Alimentaire;
import vdd.metier.Consommable;

public class PlaquesCuissonsInduction extends Consommable  implements aaa.viande.Chaleur {
	
	String chaleurPlaque = "froid";
	String etatAliment = "cru";
	
	public PlaquesCuissonsInduction () {
		super();
	}

	@Override
	public void prechauffer() {
		chaleurPlaque ="en chauffe";
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		chaleurPlaque = "chaude";
	}

	@Override
	public void cuire(Alimentaire aliment) {
		etatAliment = "crue";
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatAliment = "cuite";
	}

	@Override
	public boolean estChaud() {
		boolean estChaud = false;
		if (chaleurPlaque == "chaude") {
			estChaud = true;	
		}
		return estChaud;
	}

	@Override
	public boolean estCuit(Alimentaire aliment) {
		boolean estCuit = false;
		if (etatAliment =="cuite") {
			estCuit = true;
		}
		return estCuit;
	}

	public String getChaleurPlaque() {
		return chaleurPlaque;
	}

	public void setChaleurPlaque(String chaleurPlaque) {
		this.chaleurPlaque = chaleurPlaque;
	}

	public String getEtatAliment() {
		return etatAliment;
	}

	public void setEtatAliment(String etatAliment) {
		this.etatAliment = etatAliment;
	}
	
	

}
