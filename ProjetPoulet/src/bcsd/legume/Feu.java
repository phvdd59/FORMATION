package bcsd.legume;

public class Feu {

	private int intensiteFeu;
	private boolean allumer;

	public Feu() {
		this.intensiteFeu = 0;
		this.allumer = false;
	}

	public Feu(int intensiteFeu, boolean allumer) {
		this.intensiteFeu = intensiteFeu;
		this.allumer = allumer;
	}

	public boolean cuire(int temps, Legume legume) {
		boolean estCuit = false;

		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		estCuit = true;

		return estCuit;

	}

	public int getIntensiteFeu() {
		return intensiteFeu;
	}

	public void setIntensiteFeu(int intensiteFeu) {
		this.intensiteFeu = intensiteFeu;
	}

	public boolean isAllumer() {
		return allumer;
	}

	public void setAllumer(boolean allumer) {
		this.allumer = allumer;
	}

}
