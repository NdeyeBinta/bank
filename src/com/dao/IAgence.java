package com.dao;

import java.util.List;

import com.entities.Agence;


public interface IAgence {
	public int add(Agence agence);
	public int delete(int idA);
	public int update(Agence agence);
	public List<Agence> liste();
	public Agence get(int idA);
}
