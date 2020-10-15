package com.entities;



public class Type {
	private int idtype;
	private String nom;
	public Type() {

	}
	public Type(int idtype, String nom) {

		this.idtype = idtype;
		this.nom = nom;
	}
	public int getIdtype() {
		return idtype;
	}
	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return idtype + nom ;
	}


}
