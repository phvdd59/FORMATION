package vdd.autre;

public class MaClasseAvecInterface implements MonInterface {

	private boolean bIndicateur;
	
	@Override
	public boolean maMethodeInterface() {
		return bIndicateur;
	}

	public boolean isbIndicateur() {
		return bIndicateur;
	}

	public void setbIndicateur(boolean bIndicateur) {
		this.bIndicateur = bIndicateur;
	}

}
