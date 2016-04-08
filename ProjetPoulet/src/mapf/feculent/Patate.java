package mapf.feculent;

public class Patate extends Feculent implements Preparer {
	
	private String etatCuisson;
	private String etatPreparation;
	
	public Patate() {
		super();
	}
	
	public Patate(String etatCuisson, String etatPreparation){
		this.etatCuisson = etatCuisson;
		this.etatPreparation = etatPreparation;
	}

	@Override
	public void nettoyer() {
		
	}

	@Override
	public void eplucher() {
		
	}

}
