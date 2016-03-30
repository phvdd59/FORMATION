package ad.metier;

public class Pile {

	public static int NB_MAX = 10;
	private int[] p;
	private int sp;

	public Pile() {
		int[] p = new int[NB_MAX];
		
	}

	// public Pile(int[] p, int sp){
	// this.p=p;
	// this.sp=sp;
	// }

	public boolean estVide() {
		boolean f = false;
		for (int i = 0; i < p.length; i++) {
			if (i < 0) {
				f = true;
			}
		}
		return f;
	}

	public boolean estPleine() {
		boolean f = false;
		for (int i = 0; i < p.length; i++) {
			if (i >= 0) {
				f = true;
			}
		}
		return f;
	}

	public void empiler(int val) {
	}

	public int depiler() {
		return 0;
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
