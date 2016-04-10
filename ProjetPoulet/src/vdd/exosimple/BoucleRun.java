package vdd.exosimple;

public class BoucleRun implements Runnable {

	private boolean bArret;
	
	public BoucleRun() {
		bArret=false;
	}
	
	@Override
	public void run() {
		System.out.println("début de ma boucle");
		while(!bArret) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.print("*");
		}
		System.out.println("fin de ma boucle");
	}

	public boolean isbArret() {
		return bArret;
	}

	public void setbArret(boolean bArret) {
		this.bArret = bArret;
	}

}
