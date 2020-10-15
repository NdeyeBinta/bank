package com.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;


public   class  Operation  implements Serializable{
	private int numero;
	private LocalDate  dateOperation;
	private double montant;
	private String typeop;
	private Compte compte;
	private Employe employe;
	private Agence agence;
	public Operation() {
		super();
	}
	public Operation(int numero, LocalDate dateOperation, double montant, String typeop, Compte compte, Employe employe,
			Agence agence) {
		super();
		this.numero = numero;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.typeop = typeop;
		this.compte = compte;
		this.employe = employe;
		this.agence = agence;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LocalDate getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(LocalDate dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getTypeop() {
		return typeop;
	}
	public void setTypeop(String typeop) {
		this.typeop = typeop;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}


}
