package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Employeur;


public class EmployeurImpl implements IEmployeur {
	private DB db;
	private int ok;
	private ResultSet rs;
	public EmployeurImpl()  {
		db = new DB();
	}
	@Override
	public int add(Employeur employeur) {
		String sql="insert into employeur values(null,?,?,?,?)";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, employeur.getRaisonSocial());
			db.getPstm().setString(2, employeur.getAdressEmplCli());
			db.getPstm().setString(3, employeur.getNomEmplCli());
			db.getPstm().setInt(4, employeur.getNumIDEmplCli());
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int idEmplCli) {
		String sql= "DELETE  from employeur where idEmplCli =?";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, idEmplCli);
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;	}

	@Override
	public int update(Employeur employeur) {
		String sql= "update   employeur  set raisonSocial= ? ,adressEmplCli=?,nomEmplCli=?,numIDEmplCli=? where idEmplCli =?";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, employeur.getRaisonSocial());
			db.getPstm().setString(2, employeur.getAdressEmplCli());
			db.getPstm().setString(3, employeur.getNomEmplCli());
			db.getPstm().setInt(4,  employeur.getNumIDEmplCli());
			db.getPstm().setInt(5, employeur.getIdEmplCli());
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Employeur> liste() {
		String sql="select * from employeur";
		List<Employeur> employeurs = new ArrayList<Employeur>();
		try {
				db.initPrepar(sql);
				rs=db.executeSelect();
				while(rs.next()){
					Employeur employeur = new Employeur();
					employeur.setIdEmplCli(rs.getInt(1));
					employeur.setRaisonSocial(rs.getString(2));
					employeur.setAdressEmplCli(rs.getString(3));
					employeur.setNomEmplCli(rs.getString(4));
					employeur.setNumIDEmplCli(rs.getInt(5));
					employeurs.add(employeur);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeurs;
	}

	@Override
	public Employeur get(int idEmplCli) {
		String sql="select * from employeur where idEmplCli=?";
		Employeur employeur = null;
		try {
				db.initPrepar(sql);
				rs=db.executeSelect();
				while(rs.next()){
					employeur=new Employeur();
					employeur.setIdEmplCli(rs.getInt(1));
					employeur.setRaisonSocial(rs.getString(2));
					employeur.setAdressEmplCli(rs.getString(3));
					employeur.setNomEmplCli(rs.getString(4));
					employeur.setNumIDEmplCli(rs.getInt(5));


				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeur;
	}

}
