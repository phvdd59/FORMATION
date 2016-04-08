package vdd.autre;

public class GrandeSurface implements EssenceInterface {

	private float citerne;

	public GrandeSurface(float citerne) {
		this.citerne = citerne;
	}

	@Override
	public float donnerEssenceInterface(float qte) {
		float qteDonnee = qte;
		if (citerne < qte) {
			qteDonnee = citerne;
			citerne=0;
		} else {
			citerne -= qte;
		}
		return qteDonnee;
	}

	public float getCiterne() {
		return citerne;
	}

	public void setCiterne(float citerne) {
		this.citerne = citerne;
	}

	@Override
	public String toString() {
		return getClass().getName()+" "+getCiterne();
	}

}
