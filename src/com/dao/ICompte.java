package com.dao;

import java.util.List;

import com.entities.Compte;

public interface ICompte {
	public int add (Compte compte);
	public int addTaxeEp(double taux);
	public int addTaxeC(double decouvet) ;
	public int delete (String codeCompte);
	public int update (Compte compte);
	public List<Compte> liste();
	public Compte get(String codeCompte);
}
