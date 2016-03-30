package vdd.cedric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import vdd.frogriverone.FrogRiverOne;

public class TestfrogRiverOne {

	FrogRiverOne frogRiverOne;

	@Before
	public void before() {
		frogRiverOne = new FrogRiverOne();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
		int[] A = { 2, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 };
		int reponse = frogRiverOne.solution(8, A);
		assertEquals(8, reponse);
	}

	@Test
	public void single() {
		int[] A = { 1 };
		int reponse = frogRiverOne.solution(1, A);
		assertEquals(1, reponse);

	}

	@Test
	public void simple() {
		int[] B = { 5, 5, 5, 5, 5 };
		int reponse = frogRiverOne.solution(1, B);
		assertEquals(-1, reponse);
	}

	@Test
	public void extrem_frog() {
		int[] C = new int[999999];
		for (int i = 0; i < C.length; i++) {
			C[i] = i + 1;
		}
		int reponse = frogRiverOne.solution(1, C);
		assertEquals(999998, reponse);
	}

	@Test
	public void random_frog() {
		int[] C = new int[100];
		int X = (int) (Math.random() * (C.length - 1)) + 1;
		for (int i = 0; i < C.length; i++) {
			C[i] = (int) (Math.random() * (X)) + 1;
		}
		int reponse = frogRiverOne.solution(1, C);
		assertEquals(X - 1, reponse);
	}

	@Test
	public void random_frog1() {
		boolean[] C = new boolean[100];
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean tout = false;
		int N = C.length;
		while (!tout) {
			int val = (int) (Math.random() * (C.length));
			list.add(val);
			C[val] = true;
			tout = true;
			for (int i = 0; i < N; i++) {
				if (!C[i]) {
					tout = false;
					break;
				}
			}
		}
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i) + 1;
		}
		int reponse = frogRiverOne.solution(N, a);
		assertEquals(C.length - 1, reponse);
	}

	@Test
	public void permutation() {
		int[] D = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int val1 = (int) (Math.random() * (D.length) - 1) + 1;
		int val2 = (int) (Math.random() * (D.length) - 1) + 1;
		int temp = D[val1];
		D[val1] = D[val2];
		D[val2] = temp;
		System.out.println("permutation :");
		affTab(D);
		int reponse = frogRiverOne.solution(D.length-1,D);
	}

	@Test
	public void permutationAleatoire() {
		int[] D = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int valAleatoire = (int) (Math.random() * (D.length) - 1) + 1;
		for (int i = 0; i < valAleatoire; i++) {
			int val1 = (int) (Math.random() * (D.length) - 1) + 1;
			int val2 = (int) (Math.random() * (D.length) - 1) + 1;
			int temp = D[val1];
			D[val1] = D[val2];
			D[val2] = temp;
		}
		System.out.println("permutationAleatoire :");
		affTab(D);
		int reponse = frogRiverOne.solution(D.length-1,D);
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
