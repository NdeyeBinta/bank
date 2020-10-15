package com.dao;

import java.util.List;


import com.entities.Employeur;

public interface IEmployeur {
	public int add (Employeur employeur);
	public int delete (int idEmplCli);
	public int update (Employeur employeur);
	public List<Employeur> liste();
	public Employeur get(int idEmplCli);

}
