package com.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;




public  class Compte implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 6541265412L;
	private String codeCompte;
	private LocalDate dateCreation;
	private double solde;
	private Client client;
	private Agence agence;
	private Type type;
	public Compte() {

	}
	public Compte(String codeCompte, LocalDate dateCreation, double solde, Client client, Agence agence,Type type) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		this.agence = agence;
		this.type = type;
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return codeCompte;
	}




}
