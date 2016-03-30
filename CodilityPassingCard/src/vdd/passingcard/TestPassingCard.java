package vdd.passingcard;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPassingCard {

	PassingCard passingCard;

	@Before // le before a le mm role qu'un constructeur
	public void before() {
		passingCard = new PassingCard();
	}

	@Test
	public void test() {
		int[] a = { 0, 1, 0, 1, 1 };
		int reponse = passingCard.solution(a);
		assertEquals(5, reponse);
	}

	@Test
	public void single() {
		int[] a = { 1 };
		int reponse = passingCard.solution(a);
		assertEquals(0, reponse);
	}

	private void assertEquals(int i, int reponse) {
	}

	@Test
	public void empty() {
		int[] a = {  };
		int reponse = passingCard.solution(a);
		assertEquals(-1, reponse);
	}
	
	@Test
	public void deux(){
		int[] d = { 0, 1 };
		int reponse = passingCard.solution(d);
		assertEquals(2, reponse);
	}
	public int solution(int[] A) {
		long nb = 0;
		long n=0;
		for (int i = A.length-1; i >= 0; i--) {
			if (A[i] == 1) {
				n++;
			} else {
				nb+=n;
				if (nb > 1000000000) {
					nb=-1;
					break;
				}
			}
		}
		return (int) nb;
	}
}
