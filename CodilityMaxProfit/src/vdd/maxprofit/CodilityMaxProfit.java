package vdd.maxprofit;

public class CodilityMaxProfit {
	public static void main(String[] args) {
		CodilityMaxProfit c = new CodilityMaxProfit();
		c.init();
	}

	public void init() {
		int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
		System.out.println(solution(A));
	}

	public int solution(int[] A) {
		int r = 0;
		try {
			int v = A[0];
			int m = 0;
			for (int i = 1; i < A.length; i++) {
				if (A[i] < v) {
					r = m;
					v = A[i];
					m = 0;
				} else if (A[i] > v) {
					if (A[i] - v > m) {
						m = A[i] - v;
					}
				}
			}
			if (m > r) {
				r = m;
			}
		} catch (Exception e) {

		}
		return r;
	}
}
