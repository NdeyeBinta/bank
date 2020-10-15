package com.entities;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class CompteCourant extends Compte {
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String codeCompte, LocalDate dateCreation, double solde, Client client, Agence agence,Type type,
			double decouvert) {
		super(codeCompte, dateCreation, solde, client, agence,type);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}


}
