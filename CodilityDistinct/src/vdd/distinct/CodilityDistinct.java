package vdd.distinct;

import java.util.ArrayList;

public class CodilityDistinct {

	public static void main(String[] args) {
		CodilityDistinct c = new CodilityDistinct();
		int[] a = { 2, 1, 1, 2, 3, 1 };
		System.out.println(c.solution(a));
		int[] b = { 1 };
		System.out.println(c.solution(b));
	}

	public int solution(int[] A) { 
		int nb = 0;
		boolean[] b=new boolean[2000000];
		for (int i = 0; i < A.length; i++) {
			int v = A[i];
			if (!b[1000000+v]) {
				b[1000000+v]=true;
				nb++;
			}
		}
		return nb;
	}

	public int solution1(int[] A) { // 75%
		int nb = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			int v = A[i];
			if (!list.contains(v)) {
				list.add(v);
				nb++;
			}
		}
		return nb;
	}
}
