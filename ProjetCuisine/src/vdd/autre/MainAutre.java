package vdd.autre;

public class MainAutre {

	public static void main(String[] args) {
		MainAutre m = new MainAutre();
		m.init();
	}

	public void init() {
		StationService total = new StationService(1000);
		GrandeSurface auchan =new GrandeSurface(10000);
		EssenceInterface es=total;
		Voiture v1=new Voiture(40);
		v1.prendreEssence(total);
		Voiture v2=new Voiture(60);
		v2.prendreEssence(auchan);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(total);
		System.out.println(auchan);
	}

}
