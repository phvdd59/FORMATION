package mapf.feculent;

public class PlaquesCuissonsInuduction implements aaa.viande.Chaleur {
	
	String chaleurPlaque = "froid";
	String etatAliment = "cru";

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
	public void cuire() {
		
	}

	@Override
	public boolean estChaud() {
		return false;
	}

	@Override
	public boolean estCuit() {
		return false;
	}
	
	

}
