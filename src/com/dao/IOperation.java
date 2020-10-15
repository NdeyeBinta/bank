package com.dao;

import java.security.Timestamp;
import java.util.List;

import com.entities.Compte;
import com.entities.Operation;







public interface IOperation {
	/*public int add (Operation operation);
	public int delete (long numero);
	public int update (Operation operation);*/
	public List<Operation> liste();
	public boolean Retrait(String codeCompte,double montant);
	public boolean Depot(String codeCompte,double montant);
	public boolean Virement(String codeCompte,double montant);
	public  Operation getopId(String codeCompte);
	public int add(Operation operation);
	//public List<Consultation> getInfop(String numero,LocalDate date);
	public Operation get(int numero);
	public Compte checkCompte(String codeCompte);
}
