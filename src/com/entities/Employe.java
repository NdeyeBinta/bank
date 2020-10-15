package com.entities;

public class Employe {
	public static String  param_connexion;
	public static  int matEmp;
	private int mat;
	private String nom;
	private String prenom;
	public Employe() {

	}
	public Employe(int mat, String nom, String prenom) {

		this.mat = mat;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return  mat +  nom +  prenom ;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
