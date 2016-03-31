package vdd.distinct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CodilityDistinct {

	public static void main(String[] args) throws Exception {
		File file = new File("");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String s = reader.readLine();
			String[] lf = file.list();
		} catch (FileNotFoundException e1) {
			System.out.println("Erreur CodilityDistinct num�ro 1");
		} catch (IOException e) {
			System.out.println("Erreur CodilityDistinct num�ro 2");
		} finally {
			try {
				reader.close();
			} catch (NullPointerException e) {
				System.out.println("Erreur CodilityDistinct num�ro 4 " + "finally NULL");
			} catch (IOException e) {
				System.out.println("Erreur CodilityDistinct num�ro 3 " + "finally");
			}
		}

		CodilityDistinct c = new CodilityDistinct();
		int[] a = { 2, 1, 1, 2, 3, 1 };
		try {
			System.out.println(c.solution(a));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erreur 1");
		} catch (Exception e) {
		}
		int[] b = { 1 };
		try {
			System.out.println(c.solution(b));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erreur 2");
		}
	}

	public int solution(int[] A) throws ArrayIndexOutOfBoundsException {
		int nb = 0;
		boolean[] b = new boolean[2000];
		//		try {
		for (int i = 0; i < A.length; i++) {
			int v = A[i];
			if (!b[1000000 + v]) {
				b[1000000 + v] = true;
				nb++;
			}
		}
		//		} catch (ArrayIndexOutOfBoundsException e) {
		//			nb=-1;
		//		}
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
