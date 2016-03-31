package ag.metier.produit;

public class Conso extends Produit implements Comparable<Produit>{

	private int qte;

	public Conso() {
		super();
	}

	public Conso(String nom, float PrixUnitaire, int qte) {
		super(nom, PrixUnitaire);
		this.qte = qte;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public float getPrix() {
		return getPrixUnitaire() * getQte();
	}

	@Override
	public boolean rajoute(Produit e) {
		boolean ok = false;
		if (e instanceof Conso && e.getNom().equals(this.getNom())) {
			Conso a = (Conso) e;
			this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getQte() + a.getQte()));
			ok = true;
		}
		return ok;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj instanceof Conso) {
			Conso e = (Conso) obj;
			b = (this.getNom().equals(e.getNom()));
		}
		return b;
	}
    @Override
    public int hashCode() {
        return this.getNom().hashCode();
    }

    @Override
    public int compareTo(Produit o) {
        int retour=0;
        if (o instanceof Conso) {
                retour = this.getNom().compareTo(o.getNom());
            } else if (o instanceof Alimentaire) {
                retour = -1;
            }

        return retour;
    }
}
