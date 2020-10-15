package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Agence;


public class AgenceImpl implements IAgence {
	private DB db;
	private int ok;
	private ResultSet rs;
	public AgenceImpl() {
		db = new DB();
	}
	@Override
	public int add(Agence agence) {
		String sql = "INSERT INTO agence VALUES(null, ?, ?)";
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setString(1, agence.getNomA());
			db.getPstm().setString(2, agence.getAdressA());
			//execution de la requete
			ok = db.executeMaj();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int idA) {
		String sql= "DELETE  from agence where idA =?";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, idA);
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int update(Agence agence) {
		String sql = "update agence set nomA=?,adressA=? where  idA=?";
		ok=0;
		try{
				db.initPrepar(sql);
				db.getPstm().setString(1, agence.getNomA());
				db.getPstm().setString(2, agence.getAdressA());
				db.getPstm().setInt(3, agence.getIdA());
				ok=db.executeMaj();
		}catch(Exception e2){
			e2.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Agence> liste() {
		List<Agence> agences =new ArrayList<Agence>();
		String sql = "select * from agence";
		try{
			db.initPrepar(sql);
			rs=db.executeSelect();
			//appel du sous programme d'extraction de rs
			agences=extractRs(rs);

		}catch(Exception e){
			e.printStackTrace();
		}
		return agences;
	}
	private List<Agence> extractRs(ResultSet rs){
		List<Agence> liste = new ArrayList<Agence>();
		try{
			while(rs.next()){
				Agence agence=new Agence();
				agence.setIdA(rs.getInt(1));
				agence.setNomA(rs.getString(2));
				agence.setAdressA(rs.getString(3));
				liste.add(agence);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public Agence get(int idA) {
		String sql="select * from agence where idA=?";
		Agence agence = null;
		try {
				db.initPrepar(sql);
				db.getPstm().setInt(1, idA);
				rs=db.executeSelect();
				if(rs.next()){
					agence = new Agence();
					agence.setIdA(rs.getInt(1));
					agence.setNomA(rs.getString(2));
					agence.setAdressA(rs.getString(3));

				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agence;
	}

}
