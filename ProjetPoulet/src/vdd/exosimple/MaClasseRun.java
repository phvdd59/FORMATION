package vdd.exosimple;

public class MaClasseRun implements Runnable {

	@Override
	public void run() {
		System.out.println("Début de mon Run");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().isAlive());
		System.out.println("Fin de mon Run");
	}

}
