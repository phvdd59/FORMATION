package vdd.autre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadReveil extends Thread {

	private boolean sortir;

	public ThreadReveil() {
		this.setName("reveil");
		sortir=false;
	}

	@Override
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!sortir) {
			System.out.println("appuyez sur ENTRER");
			try {
				in.readLine();
				System.out.println("Debout la dedans");
				synchronized (this) {
					notify();
				}
			} catch (IOException e) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("FIN DE REVEIL");
	}

	public boolean isSortir() {
		return sortir;
	}

	public void setSortir(boolean sortir) {
		this.sortir = sortir;
	}
}
