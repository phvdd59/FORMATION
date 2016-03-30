package ad.frogriverone;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import vdd.frogriverone.FrogRiverOne;

public class TestFrogRiverOne {

	FrogRiverOne frogRiverOne;

	@Before // le before a le mm role qu'un constructeur
	public void before() {
		frogRiverOne = new FrogRiverOne();
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		int[] A = { 2, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 }; // à nous d'inventer
															// le tableau pr
															// l'exemple
		int reponse = frogRiverOne.solution(8, A);
		assertEquals(8, reponse);
	}

	@Test
	public void single() {
		int[] a = { 1 };
		int reponse = frogRiverOne.solution(1, a);
		assertEquals(0, reponse);// 0 est la position du tableau
	}

	// @Test
	// public void simple(){
	// int[] b = {5,5,5,5,5,5};
	// int reponse = frogRiverOne.solution(5, b);
	// assertEquals (-1,reponse);
	// }
	@Test
	public void simple() {
		int[] a = { 8, 7, 5, 9, 6, 5, 4, 4, 4, 2, 3, 1, 4, 7, 9, 8 };
		int reponse = frogRiverOne.solution(9, a);
		assertEquals(11, reponse);
	}

	@Test
	public void extreme_frog() {
		int[] a = new int[99999];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;// +1 car commence à 1 et non -1 car on part de 0 et on
							// ne
							// descend pas de a.length
		}
		int reponse = frogRiverOne.solution(99999, a);
		assertEquals(99998, reponse);
	}

	@Test
	public void small_random() {
		boolean[] nb = new boolean[10];
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
		}
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i) + 1;
		}
		int x = a.length - 1;
		assertEquals(x, frogRiverOne.solution(nb.length, a));
	}

	@Test // echange de val1 avec val2
	public void permutation() {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		for (int i = 0; i < 3; i++) {
			int val1 = (int) (Math.random() * a.length - 1);
			int val2 = (int) (Math.random() * a.length - 1);
			int z = a[val1];
			a[val1] = a[val2];
			a[val2] = z;
		}
		assertEquals(a.length - 1, frogRiverOne.solution(a.length, a));

	}
}
