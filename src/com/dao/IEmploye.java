package com.dao;


import java.util.List;

import com.entities.Employe;



public interface IEmploye {
	public int add(Employe employe);
	public int delete(int mat);
	public int update(Employe employe);
	public List<Employe> liste();
	public Employe get(int mat);
}
