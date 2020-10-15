package com.entities;

public class Agence {
	private int idA;
	private String nomA;
	private String adressA;
	public Agence() {

	}
	public Agence(int idA, String nomA, String adressA) {

		this.idA = idA;
		this.nomA = nomA;
		this.adressA = adressA;
	}
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public String getNomA() {
		return nomA;
	}
	public void setNomA(String nomA) {
		this.nomA = nomA;
	}
	public String getAdressA() {
		return adressA;
	}
	public void setAdressA(String adressA) {
		this.adressA = adressA;
	}
	@Override
	public String toString() {
		return idA +  nomA + adressA ;
	}


}
