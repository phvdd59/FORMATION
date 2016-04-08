package vdd.metier;

import java.io.Serializable;

public abstract class Produit implements Serializable, Comparable<Produit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int CPT;

	private int id;
	private String nom;

	public Produit() {
		id = CPT;
		CPT++;
	}

	public Produit(String nom) {
		id = CPT;
		CPT++;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return getNom();
	}

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}