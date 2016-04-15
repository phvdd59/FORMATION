package vdd.fibfrog;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibFrog {

	public static void main(String[] args) {
		FibFrog fibFrog = new FibFrog();
		int[] e = { 1, 1, 0, 0, 0 };
		System.out.println(fibFrog.solution(e));
		int[] b = { 0 };
		System.out.println(fibFrog.solution(b));
		int[] l = {};
		System.out.println(fibFrog.solution(l));
		int[] a = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
		System.out.println(fibFrog.solution(a));
		int[] c = { 1, 1 };
		System.out.println(fibFrog.solution(c));
		int[] d = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(fibFrog.solution(d));
		int[] f = { 1, 1, 1 };
		System.out.println(fibFrog.solution(f));
		int[] g = { 1 };
		System.out.println(fibFrog.solution(g));
		int[] h = new int[100];
		for (int i = 0; i < h.length; i += 2) {
			h[i] = 1;
			h[i + 1] = 1;
		}
		System.out.println("--------------------");
		System.out.println(fibFrog.solution(h));
	}

	public int solution(int[] A) {
		int res = 0;
		boolean[] b = new boolean[A.length + 2];
		affA(A);
		ArrayList<Integer> f = creFib(A.length);
		aff(f);
		boolean flip = false;
		ArrayList<Integer> positionsDeDepart1 = new ArrayList<Integer>();
		ArrayList<Integer> positionsDeDepart2 = new ArrayList<Integer>();
		positionsDeDepart1.add(-1);
		ArrayList<Integer> posTrouvee = null;
		boolean trouve = false;
		while (!flip && positionsDeDepart1.size() > 0 || flip && positionsDeDepart2.size() > 0) {
			res++;
			if (!flip) {
				positionsDeDepart2 = rechercherPosPossible(f, A, positionsDeDepart1, b);
				aff(positionsDeDepart2);
				posTrouvee = positionsDeDepart2;
			} else {
				positionsDeDepart1 = rechercherPosPossible(f, A, positionsDeDepart2, b);
				aff(positionsDeDepart1);
				posTrouvee = positionsDeDepart1;
			}
			if (posTrouvee.size() > 0 && posTrouvee.get(posTrouvee.size()-1) == A.length) {
				// Arrivée
				trouve = true;
				System.out.println("je suis arrivé");
				break;
			} else {
				flip = !flip;
			}
		}
		if (!trouve) {
			res = -1;
		}
		return res;
	}

	public ArrayList<Integer> rechercherPosPossible(ArrayList<Integer> f, int[] A, ArrayList<Integer> positionsDeDepart, boolean[] b) {
		ArrayList<Integer> positionsTrouvee = new ArrayList<Integer>();
		// partir de toutes les positions actuelles.
		sortie: for (Integer posDebut : positionsDeDepart) {
			if (!b[posDebut + 1]) {
				b[posDebut + 1] = true;
				// rechercher suivant la suite de fibonacci les sauts possibles.
				for (Integer nbFibonacci : f) {
					int saut = posDebut + nbFibonacci;
					if (saut <= A.length && !b[saut + 1]) {
						if (saut < A.length) {
							if (A[saut] == 1) {
								positionsTrouvee.add(saut);
							}
						} else {
							if (saut == A.length) {
								positionsTrouvee.add(saut);
								break sortie;
							} else {
								//break;
							}
						}
					}
				}
			}
		}
		return positionsTrouvee;
	}

	public ArrayList<Integer> creFib(int len) {
		ArrayList<Integer> f = new ArrayList<Integer>();
		if (len > 0) {
			if (len == 1) {
				f.add(0, 1);
				f.add(0, 2);
			} else {
				int vNmoins2 = 1;
				int vNmoins1 = 2;
				f.add(vNmoins1);
				f.add(vNmoins2);
				int vN = vNmoins2 + vNmoins1;
				while (vN <= len + 1) {
					f.add(0, vN);
					vNmoins2 = vNmoins1;
					vNmoins1 = vN;
					vN = vNmoins2 + vNmoins1;
				}
			}
		} else {
			f.add(0, 1);
		}
		return f;
	}

	public void affA(int[] A) {
		System.out.print("[");
		for (int i = 0; i < A.length - 1; i++) {
			System.out.print(A[i] + ",");
		}
		if (A.length > 0) {
			System.out.print(A[A.length - 1] + "]");
		} else {
			System.out.print("]");
		}
		System.out.println();
	}

	private void aff(ArrayList<Integer> ls) {
		System.out.print("[");
		if (ls.size() > 0) {
			for (int i = 0; i < ls.size() - 1; i++) {
				System.out.print(ls.get(i) + ",");
			}
			System.out.println(ls.get(ls.size() - 1) + "]");
		} else {
			System.out.println("]");
		}
	}

	public int solution1(int[] A) {
		int ret = 0;
		ArrayList<Integer> f = new ArrayList<Integer>();
		f.add(0);
		f.add(1);
		int i = 2;
		int v = f.get(0) + f.get(1);
		while (v <= A.length + 1) {
			f.add(v);
			i++;
			v = f.get(i - 1) + f.get(i - 2);

		}
		int pos = -1;
		boolean trouve = true;
		while (trouve && pos != A.length) {
			trouve = false;
			for (int k = f.size() - 1; k >= 2; k--) {
				int z = f.get(k);
				if (pos + z == A.length || pos + z < A.length && A[pos + z] == 1) {
					trouve = true;
					ret++;
					pos += z;
					break;
				}
			}
		}
		if (pos != A.length) {
			ret = -1;
		}
		return ret;
	}

}
