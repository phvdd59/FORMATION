package vdd.frogjmp;

public class CodilityFrogJmp {
	public static void main(String[] args) {
		CodilityFrogJmp c = new CodilityFrogJmp();
		int n = c.solution(10, 85, 30);
		System.out.println(n);
	}

	int solution(int X, int Y, int D) {
		int nbSaut = 0;
		int d = Y - X;

		if (D > 0 && X <= Y && X > 0 && Y > 0 && D < d) {
			nbSaut = (int) Math.ceil(((double) (Y - X) / (double) D));
		} else if (X == Y) {
			nbSaut = 0;
		} else if (D > (d)) {
			nbSaut = 1;
		}

		return nbSaut;
	}
}
