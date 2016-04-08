package vdd.fish;

import java.util.ArrayList;

public class CodilityFish {
	public static void main(String[] args) {

		CodilityFish codilityFish = new CodilityFish();
		codilityFish.init();
	}

	public void init() {
		int[] A = { 8, 7, 3, 4, 5 };
		int[] B = { 0, 1, 1, 0, 0 };
		System.out.println(solution1(A, B));
	}

	public int solution(int[] A, int[] B) { // 100%
		int r = 0;
		ArrayList<Integer> pile = new ArrayList<Integer>();
		for (int i = 0; i < B.length; i++) {
			if (B[i] == 0) {
				r++;
				for (int j = pile.size()-1; j >= 0; j--) {
					if (A[pile.get(j).intValue()] > A[i]) {
						r--;
						break;
					} else if (A[pile.get(j).intValue()] < A[i]) {
						r--;
						pile.remove(pile.size()-1);
					}
				}
			} else {
				r++;
				pile.add(i);
			}
		}
		return r;
	}

	public int solution1(int[] A, int[] B) { // 62%
		int r = A.length;
		int[] pile = new int[A.length];
		int indPile = -1;
		for (int i = 0; i < B.length; i++) {
			if (B[i] == 1) {
				indPile++;
				pile[indPile] = i;
			} else {
				for (int j = 0; j < indPile + 1; j++) {
					if (A[i] > 0) {
						if (A[pile[j]] > A[i]) {
							r--;
							A[i] = 0;
						} else {
							A[pile[j]] = 0;
							r--;
						}
					}
				}
			}
		}
		return r;
	}
}
