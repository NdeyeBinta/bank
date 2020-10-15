package com.dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Employe;




public class EpmloyeImpl  implements IEmploye{
	private DB db;
	private int ok;
	private ResultSet rs;
	public EpmloyeImpl() {
		db = new DB();
	}
	@Override
	public int add(Employe employe) {
		String sql = "INSERT INTO employe VALUES(null, ?, ?)";
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setString(1, employe.getNom());
			db.getPstm().setString(2, employe.getPrenom());
			//execution de la requete
			ok = db.executeMaj();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int mat) {
		String sql= "DELETE  from employe where mat =?";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, mat);
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int update(Employe employe) {
		String sql = "update employe set nom=?,prenom=? where  mat=?";
		ok=0;
		try{
				db.initPrepar(sql);
				db.getPstm().setString(1, employe.getNom());
				db.getPstm().setString(2, employe.getPrenom());
				db.getPstm().setInt(3, employe.getMat());
				ok=db.executeMaj();
		}catch(Exception e2){
			e2.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Employe> liste() {
		List<Employe> employes =new ArrayList<Employe>();
		String sql = "select * from employe";
		try{
			db.initPrepar(sql);
			rs=db.executeSelect();
			//appel du sous programme d'extraction de rs
			employes=extractRs(rs);

		}catch(Exception e){
			e.printStackTrace();
		}
		return employes;
	}
	private List<Employe> extractRs(ResultSet rs){
		List<Employe> liste = new ArrayList<Employe>();
		try{
			while(rs.next()){
				Employe employe=new Employe();
				employe.setMat(rs.getInt(1));
				employe.setNom(rs.getString(2));
				employe.setPrenom(rs.getString(3));
				liste.add(employe);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public Employe get(int mat) {
		String sql="select * from employe where mat=?";
		Employe employe = null;
		try {
				db.initPrepar(sql);
				db.getPstm().setInt(1, mat);
				rs=db.executeSelect();
				if(rs.next()){
					employe = new Employe();
					employe.setMat(rs.getInt(1));
					employe.setNom(rs.getString(2));
					employe.setPrenom(rs.getString(3));

				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employe;
	}

}
