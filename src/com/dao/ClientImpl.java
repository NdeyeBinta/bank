package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Client;
import com.entities.Employeur;





public class ClientImpl implements IClient {
	private DB db;
	private int ok;
	private ResultSet rs;
	public ClientImpl()  {
		db = new DB();
	}
	@Override
	public int add(Client client) {
		String sql="insert into client values(null,?,?,?,?,?,?,?,?,?)";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, client.getNomCli());
			db.getPstm().setString(2, client.getPrenomCli());
			db.getPstm().setString(3, client.getAdressCli());
			db.getPstm().setString(4, client.getEmailCli());
			db.getPstm().setInt(5, client.getTelCli());
			db.getPstm().setDouble(6, client.getSalaire());
			db.getPstm().setString(7, client.getProfession());
			db.getPstm().setInt(8, client.getNumID());
			db.getPstm().setInt(9, client.getEmployeur().getIdEmplCli());
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int idCli) {
		String sql= "DELETE  from client where idCli =?";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, idCli);
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int update(Client client) {
		String sql= "update   client  set email= ? ,password=?,etat=?,mat=? where id =?";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, client.getNomCli());
			db.getPstm().setString(2, client.getPrenomCli());
			db.getPstm().setString(3, client.getAdressCli());
			db.getPstm().setString(4, client.getEmailCli());
			db.getPstm().setInt(5, client.getTelCli());
			db.getPstm().setDouble(6, client.getSalaire());
			db.getPstm().setString(7, client.getProfession());
			db.getPstm().setInt(8, client.getNumID());
			db.getPstm().setInt(9, client.getEmployeur().getIdEmplCli());
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Client> liste() {
		String sql="select * from client c,employeur e where c.idEmplCli=e.idEmplCli";
		List<Client> clients = new ArrayList<Client>();
		try {
				db.initPrepar(sql);
				rs=db.executeSelect();
				while(rs.next()){
					Client client = new Client();
					client.setIdCli(rs.getInt(1));
					client.setNomCli(rs.getString(2));
					client.setPrenomCli(rs.getString(3));
					client.setAdressCli(rs.getString(4));
					client.setEmailCli(rs.getString(5));
					client.setTelCli(rs.getInt(6));
					client.setSalaire(rs.getDouble(7));
					client.setProfession(rs.getString(8));
					client.setNumID(rs.getInt(9));
					client.setEmployeur(new Employeur());
					client.getEmployeur().setNomEmplCli(rs.getString("e.nomEmplCli"));
					clients.add(client);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client get(int idCli) {
		String sql="select * from client where idCli=?";
		Client client=null;
		try {
				db.initPrepar(sql);
				db.getPstm().setInt(1, idCli);
				rs=db.executeSelect();
				while(rs.next()){
					client=new Client();
					client.setIdCli(rs.getInt(1));
					client.setNomCli(rs.getString(2));
					client.setPrenomCli(rs.getString(3));
					client.setAdressCli(rs.getString(4));
					client.setEmailCli(rs.getString(5));
					client.setTelCli(rs.getInt(6));
					client.setSalaire(rs.getDouble(7));
					client.setProfession(rs.getString(8));
					client.setNumID(rs.getInt(9));
					client.setEmployeur(new EmployeurImpl().get(rs.getInt(10)));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

}
