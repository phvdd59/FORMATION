package mapf.feculent;

public class Patate extends Feculent implements Preparer {

	private String etatCuisson;
	private String etatPreparation;
	private String etatProprete = "sale";

	public Patate() {
		super();
	}

	public Patate(String etatCuisson, String etatPreparation) {
		this.etatCuisson = etatCuisson;
		this.etatPreparation = etatPreparation;
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

}
