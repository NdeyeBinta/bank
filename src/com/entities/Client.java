package com.entities;

import java.io.Serializable;

public class Client implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 6978115779723813718L;
	private int idCli;
	private String nomCli;
	private String prenomCli;
	private String adressCli;
	private String emailCli;
	private int telCli;
	private double salaire;
	private String profession;
	private int numID;
	private Employeur employeur;
	public Client() {

	}
	public Client(int idCli, String nomCli, String prenomCli, String adressCli, String emailCli, int telCli,
			double salaire, String profession, int numID, Employeur employeur) {
		super();
		this.idCli = idCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adressCli = adressCli;
		this.emailCli = emailCli;
		this.telCli = telCli;
		this.salaire = salaire;
		this.profession = profession;
		this.numID = numID;
		this.employeur = employeur;
	}
	public int getIdCli() {
		return idCli;
	}
	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getPrenomCli() {
		return prenomCli;
	}
	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}
	public String getAdressCli() {
		return adressCli;
	}
	public void setAdressCli(String adressCli) {
		this.adressCli = adressCli;
	}
	public String getEmailCli() {
		return emailCli;
	}
	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}
	public int getTelCli() {
		return telCli;
	}
	public void setTelCli(int telCli) {
		this.telCli = telCli;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getNumID() {
		return numID;
	}
	public void setNumID(int numID) {
		this.numID = numID;
	}
	public Employeur getEmployeur() {
		return employeur;
	}
	public void setEmployeur(Employeur employeur) {
		this.employeur = employeur;
	}
	@Override
	public String toString() {
		return idCli+ nomCli +prenomCli;
	}



}
