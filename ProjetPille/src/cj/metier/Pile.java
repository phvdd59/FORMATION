package cj.metier;

public class Pile {

	public static int NBMAX = 10;

	private int[] p;
	private int sp = -1;

	public Pile() {
		this.p = null;
		this.sp = 0;
	}

	public boolean estVide() {
		boolean bool = false;
		// if (this.getP().equals(null) ) {
		// bool = true;}
		if (sp == -1) {
			bool = true;
		}
		return bool;
	}

	public boolean estPleine() {
		boolean bool = true;
		// if (this.getP().equals(null)) {
		// bool = false;
		// }
		if (sp < NBMAX) {
			bool = false;
		}
		return bool;
	}

	public void empiler(int val) {
		if (this.sp < NBMAX) {
			this.sp++;
			this.p = new int[sp];
			this.p[sp] = val;
		}
	}

	public int depiler() {
		int valDepiler = -1;
		if (sp != -1) {
			valDepiler = this.p[sp];
			this.p[sp] = 0;
			this.sp--;
		}
		return valDepiler;
	}

	// Getters and setters
	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

}
