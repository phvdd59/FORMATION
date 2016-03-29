package vdd.vdd;

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
		//fail("Not yet implemented");
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
		int[] a = { 5, 5, 5, 5, 5 };
		int reponse = frogRiverOne.solution(5, a);
		assertEquals(-1, reponse);
		int[] b = { 1, 2, 3, 4, 5 };
		reponse = frogRiverOne.solution(5, b);
		assertEquals(4, reponse);
	}

	@Test
	public void extreme_frog() {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		assertEquals(99999, frogRiverOne.solution(100000, a));
		int[] b = new int[100000];
		for (int i = 0; i < a.length; i++) {
			b[i] = b.length - i;
		}
		assertEquals(99999, frogRiverOne.solution(100000, b));
	}

	@Test
	public void small_random1() {
		int suite=(int) (Math.random()*10);
		int cpt=0;
		int x=-1;
		boolean[] nb = new boolean[3];
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean tout=false;
		while(!tout) {
			int val=(int) (Math.random()*nb.length);
			list.add(val);
			nb[val]=true;
			tout=true;
			for (int i = 0; i < nb.length; i++) {
				if (!nb[i]) {
					tout=false;
					break;
				}
			}
			if (tout) {
				x=list.size();
				if (cpt < suite) {
					tout=false;
				}
				cpt++;
			}
		}
		int[] a=new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i]=list.get(i)+1;
		}
		assertEquals(x, frogRiverOne.solution(nb.length, a));
	}
}
