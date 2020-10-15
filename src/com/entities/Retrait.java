package com.entities;

import java.security.Timestamp;
import java.time.LocalDate;


public class Retrait extends Operation {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(int numero, LocalDate dateOperation, double montant, String typeop, Compte compte, Employe employe,
			Agence agence) {
		super(numero, dateOperation, montant, typeop, compte, employe, agence);
		// TODO Auto-generated constructor stub
	}

	

}
