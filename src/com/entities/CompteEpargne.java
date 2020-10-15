package com.entities;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class CompteEpargne  extends Compte{
	private double Taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String codeCompte, LocalDate dateCreation, double solde, Client client, Agence agence,Type type,
			double taux) {
		super(codeCompte, dateCreation, solde, client, agence,type);
		Taux = taux;
	}

	public double getTaux() {
		return Taux;
	}

	public void setTaux(double taux) {
		Taux = taux;
	}

}
