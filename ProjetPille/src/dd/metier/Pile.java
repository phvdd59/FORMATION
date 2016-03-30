package dd.metier;

public class Pile {

	private int[] p;
	private int sp;

	public Pile() {
		this.p = null;
		this.sp = -1; // nb elements -1=vide
	}

	public boolean estVide() {
		boolean bool = false;
		if (sp == -1) {
			bool = true;
		}
		return bool;
	}

	public boolean estPlein() {
		boolean bool = false;
		if (sp == this.p.length && sp >0 ) {
			bool = true;
		}
		return bool;
	}

	public void empiler(int val) {
		if (sp != -1) {
			this.p[this.sp] = val;
			this.sp++;
		}
	}

	public int depiler() {
		int res = 0;
		if (sp > 0) {
			res = this.p[this.sp - 1];
			this.p[sp - 1] = 0;
			this.sp--;
		}
		return res;
	}

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
