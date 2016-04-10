package vdd.autre;

import java.text.DecimalFormat;

public class ThreadSommeil extends Thread {

	private int nbDeReveil;

	public ThreadSommeil(int nbDeReveil) {
		this.nbDeReveil = nbDeReveil;
	}

	@Override
	public void run() {
		ThreadReveil reveil = new ThreadReveil();
		reveil.start();

		long t = System.nanoTime();
		for (int i = 0; i < nbDeReveil; i++) {
			synchronized (reveil) {
				try {
					reveil.wait();
				} catch (InterruptedException e) {
				}
				System.out.println("J'ai dormis " + difToString(t, System.nanoTime()));
				t = System.nanoTime();
			}
		}
		reveil.setSortir(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("arret de someil");
	}

	private String difToString(long avant, long apres) {
		double dif = ((double) apres - avant) / 1000000;
		DecimalFormat df = new DecimalFormat("#####.00");
		return df.format(dif)+" ms";
	}
}
