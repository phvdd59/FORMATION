package vdd.autre;

public class MainAutre {

	public static void main(String[] args) {
		MainAutre m = new MainAutre();
	}

	public void init() {
		MaClasseAvecInterface monObjetAvecInterface = new MaClasseAvecInterface();
		monObjetAvecInterface.setbIndicateur(true);
		ExploiteInterface ex = new ExploiteInterface(monObjetAvecInterface);
	}

}
