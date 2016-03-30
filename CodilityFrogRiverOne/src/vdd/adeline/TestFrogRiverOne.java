package vdd.adeline;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import vdd.frogriverone.FrogRiverOne;

public class TestFrogRiverOne {

	FrogRiverOne frogRiverOne;

	@Before
	public void before() {
		frogRiverOne = new FrogRiverOne();
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		int[] A = { 2, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 };
		int reponse = frogRiverOne.solution(8, A);
		assertEquals(8, reponse);
	}

	@Test
	public void single() {
		int[] a = { 1 };
		int reponse = frogRiverOne.solution(1, a);
		assertEquals(0, reponse);
	}

	@Test
	public void simple() {
		int[] b = { 5, 5, 5, 5, 5 };
		int reponse = frogRiverOne.solution(5, b);
		assertEquals(-1, reponse);
		int[] a = { 1, 2, 3, 4, 5 };
		reponse = frogRiverOne.solution(5, a);
		assertEquals(4, reponse);
	}

	@Test
	public void normal() {
		int[] c = { 2, 3, 1, 4, 5, 6, 1 };
		int reponse = frogRiverOne.solution(4, c);
		assertEquals(3, reponse);
	}

	@Test
	public void extreme_Frog() {
		int[] tab = new int[100000];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = i + 1;
		}
		int reponse = frogRiverOne.solution(100000, tab);
		assertEquals(99999, reponse);
	}

	@Test
	public void smallRandom() {
		int suite = (int) (Math.random() * 10);
		int cpt = 0;
		int x = -1;
		boolean[] nb = new boolean[3];
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean tout = false;
		while (!tout) {
			int val = (int) (Math.random() * nb.length);
			list.add(val);
			nb[val] = true;
			tout = true;
			for (int i = 0; i < nb.length; i++) {
				if (!nb[i]) {
					tout = false;
					break;
				}
			}
			if (tout) {
				x = list.size();
				if (cpt < suite) {
					tout = false;
				}
				cpt++;
			}
		}
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i) + 1;
		}
		assertEquals(x, frogRiverOne.solution(nb.length, a));

	}

	@Test
	public void permutation() {
		int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < 20; i++) {
			int val1 = (int) (Math.random() * 9);
			int val2 = (int) (Math.random() * 9);
			int t = 0;
			t = tab[val1];
			tab[val1] = tab[val2];
			tab[val2] = t;
		}
		int x = tab.length;
		int reponse = frogRiverOne.solution(x, tab);
		assertEquals(x - 1, reponse);

	}

}
