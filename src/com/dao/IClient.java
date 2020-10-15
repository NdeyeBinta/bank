package com.dao;

import java.util.List;

import com.entities.Client;



public interface IClient {
	public int add (Client client);
	public int delete (int idCli);
	public int update (Client client);
	public List<Client> liste();
	public Client get(int idCli);

}
