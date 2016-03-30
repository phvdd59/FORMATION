package dd.testjunit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import vdd.frogriverone.FrogRiverOne;

public class TestFrogRiverOne {

	FrogRiverOne frogRiverOne;

	public void before() {
		frogRiverOne = new FrogRiverOne();
	}

	@Test
	public void test() {

		int[] A = { 2, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 };
		int reponse = frogRiverOne.solution(8, A);
		assertEquals(8, reponse);

	}

	@Test
	public void single() {

		int[] A = { 1 };
		int reponse = frogRiverOne.solution(1, A);
		assertEquals(0, reponse);

	}

	@Test
	public void simple() {

		int[] a = { 5, 5, 5, 5, 5 };
		int reponse = frogRiverOne.solution(5, a);
		assertEquals(-1, reponse);

		int[] b = { 1, 2, 3, 4, 5 };
		reponse = frogRiverOne.solution(5, b);
		assertEquals(4, reponse);

	}

	@Test
	public void extreme_frog() {
		int[] a = new int[99999];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		int reponse = frogRiverOne.solution(99999, a);
		assertEquals(99998, reponse);
	}

	@Test
	public void random_frog() {
		boolean[] nb = new boolean[3];
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean tout = false;
		while (!tout) {
			int val = (int) (Math.random() * nb.length);
			list.add(val);
			nb[val] = true;
			tout = true;
		}
		for (int i = 0; i < nb.length; i++) {
			if (!nb[i]) {
				tout = false;
				break;
			}
		}

		// int reponse = frogRiverOne.solution(3, nb);
		// assertEquals(99998, reponse);
	}

	@Test
	public void permutation() {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int valAleatoire = (int) (Math.random() * (a.length - 1));
		for (int i = 0; i < a.length; i++) {
			int val1 = (int) Math.random() * (a.length - 1);
			int val2 = (int) Math.random() * (a.length - 1);
			int b = a[val1];
			a[val2] = a[val1];
			a[val1] = b;
		}
		int reponse = frogRiverOne.solution(a.length, a);
		assertEquals(a.length - 1, reponse);

	}

}
