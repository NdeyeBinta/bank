package com.entities;

public class Employeur {
	private int idEmplCli;
	private String raisonSocial;
	private String adressEmplCli;
	private String nomEmplCli;
	private int numIDEmplCli;
	public Employeur() {

	}
	public Employeur(int idEmplCli, String raisonSocial, String adressEmplCli, String nomEmplCli, int numIDEmplCli) {

		this.idEmplCli = idEmplCli;
		this.raisonSocial = raisonSocial;
		this.adressEmplCli = adressEmplCli;
		this.nomEmplCli = nomEmplCli;
		this.numIDEmplCli = numIDEmplCli;
	}

	@Override
	public String toString() {
		return  nomEmplCli   ;
	}
	public int getIdEmplCli() {
		return idEmplCli;
	}
	public void setIdEmplCli(int idEmplCli) {
		this.idEmplCli = idEmplCli;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public String getAdressEmplCli() {
		return adressEmplCli;
	}
	public void setAdressEmplCli(String adressEmplCli) {
		this.adressEmplCli = adressEmplCli;
	}
	public String getNomEmplCli() {
		return nomEmplCli;
	}
	public void setNomEmplCli(String nomEmplCli) {
		this.nomEmplCli = nomEmplCli;
	}
	public int getNumIDEmplCli() {
		return numIDEmplCli;
	}
	public void setNumIDEmplCli(int numIDEmplCli) {
		this.numIDEmplCli = numIDEmplCli;
	}



}
