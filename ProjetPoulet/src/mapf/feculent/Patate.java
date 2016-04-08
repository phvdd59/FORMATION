package mapf.feculent;

import java.util.ArrayList;

public class Patate extends vdd.metier.Alimentaire implements Preparer {

	private String etatCuisson;
	private String etatPreparation;
	private String etatProprete;;

	public Patate() {
		super();
		this.etatPreparation = "habillee";
		this.etatProprete = "sale";
	}

	
	public ArrayList<Patate> filetDePatate (int n) {
		Patate patate = new Patate();
		ArrayList <Patate> filetDePatate = new ArrayList <Patate>();
		int i = 0;
		while (i != n) {
			filetDePatate.add(patate);
			i++;
		}
		return filetDePatate;
	}

	
	@Override
	public void nettoyer() {
		etatProprete = "sale";
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatProprete = "propre";
	}

	@Override
	public void eplucher() {
		etatPreparation = "habillee";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatPreparation = "epluchee";
	}

	public String getEtatCuisson() {
		return etatCuisson;
	}

	public void setEtatCuisson(String etatCuisson) {
		this.etatCuisson = etatCuisson;
	}

	public String getEtatPreparation() {
		return etatPreparation;
	}

	public void setEtatPreparation(String etatPreparation) {
		this.etatPreparation = etatPreparation;
	}

	public String getEtatProprete() {
		return etatProprete;
	}

	public void setEtatProprete(String etatProprete) {
		this.etatProprete = etatProprete;
	}

}
