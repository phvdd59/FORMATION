package vdd.cyclicrotation;

public class CyclicRotation {
	public static void main(String[] args) {
		CyclicRotation b = new CyclicRotation();
		b.init();
	}

	private void init() {
		int[] a={3, 8, 9, 7, 6};
		affTab(solution(a, 3));
	}

	public int[] solution(int[] A, int K) {
		return null;
	}
	
	public void affTab(int[] t){
		System.out.print("[");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]);
			if (i < t.length-1) {
				System.out.print(" ,");
			}
		}
		System.out.println("]");
	}
}
