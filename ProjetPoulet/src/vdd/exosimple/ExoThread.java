package vdd.exosimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import vdd.autre.ThreadReveil;
import vdd.autre.ThreadSommeil;

public class ExoThread {

	public static void main(String[] args) {
		ExoThread exoThread = new ExoThread();
		//exoThread.exerciceSeulThreadMain();
		exoThread.exerciceThreadMainPlusUnRun();
		//exoThread.exerciceThreadBoucle();
		//exoThread.exerciceInterruption();
	}

	private void exerciceInterruption() {
		ThreadSommeil threadSommeil=new ThreadSommeil(3);
		threadSommeil.start();
	}

	private void exerciceThreadBoucle() {
		BoucleRun boucleRun = new BoucleRun();
		Thread threadBoucle = new Thread(boucleRun, "Thread BOUCLE");
		threadBoucle.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			in.readLine();
			boucleRun.setbArret(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * le Main est bien un Thread
	 */
	public void exerciceSeulThreadMain() {
		System.out.println("Avant mise en attente thread main");
		long avant = System.nanoTime();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		long apres = System.nanoTime();
		String sDif = difToString(avant, apres);
		System.out.println("Apres attente thread main " + sDif);
	}

	/**
	 * vie et mort des Thread(s)
	 */
	public void exerciceThreadMainPlusUnRun() {
		System.out.println(Thread.currentThread().getName());
		MaClasseRun maClasseRun = new MaClasseRun();
		Thread monThread = new Thread(maClasseRun);
		monThread.setName("second Thread");
		monThread.start();
		System.out.println("Avant mise en attente thread main");
		long avant = System.nanoTime();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		long apres = System.nanoTime();
		String sDif = difToString(avant, apres);
		System.out.println("Apres attente thread Main " + sDif);
	}

	private String difToString(long avant, long apres) {
		double dif = ((double) apres - avant) / 1000000;
		DecimalFormat df = new DecimalFormat("#####.00");
		return df.format(dif);
	}
}
