package com.entities;



public class User {
	private int id;
	private String email;
	private String password;
	private String Libelle;
	private Employe mat;
	public static String param_connexion;
	public User() {

	}
	public User(int id, String email, String password, String libelle, Employe mat) {

		this.id = id;
		this.email = email;
		this.password = password;
		Libelle = libelle;
		this.mat = mat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Employe getMat() {
		return mat;
	}
	public void setMat(Employe mat) {
		this.mat = mat;
	}


}
