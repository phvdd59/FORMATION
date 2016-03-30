package vdd.frogriverone;

public class FrogRiverOne {

	public static void main(String[] args) {
		FrogRiverOne b = new FrogRiverOne();
		b.init();
	}

	private void init() {
		int[] a = { 1, 3, 1, 4, 2, 3, 5, 4 };
		System.out.println(solution(5, a));
	}

	public int solution(int X, int[] A) {
		int n = -1;
		boolean[] pos = new boolean[X];
		int j = 1;
		z: for (int i = 0; i < A.length; i++) {
			pos[A[i]-1] = true;
			if (A[i] == j) {
				while (pos[j-1]) {
					if (j == X) {
						n=i;
						break z;
					}
					j++;
				}
			}
		}
		//System.out.println(n);
		return n;
	}

	public void affTab(int[] t) {
		System.out.print("[");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]);
			if (i < t.length - 1) {
				System.out.print(" ,");
			}
		}
		System.out.println("]");
	}
}
