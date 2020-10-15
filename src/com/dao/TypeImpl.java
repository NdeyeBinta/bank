package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Agence;
import com.entities.Employe;
import com.entities.Type;

public class TypeImpl  implements IType{
	private DB db;
	private int ok;
	private ResultSet rs;
	public TypeImpl() {
		db = new DB();
	}
	@Override
	public List<Type> liste() {
		List<Type> types =new ArrayList<Type>();
		String sql = "select * from type";
		try{
			db.initPrepar(sql);
			rs=db.executeSelect();
			//appel du sous programme d'extraction de rs
			types=extractRs(rs);

		}catch(Exception e){
			e.printStackTrace();
		}
		return types;
	}
	private List<Type> extractRs(ResultSet rs){
		List<Type> liste = new ArrayList<Type>();
		try{
			while(rs.next()){
				Type type=new Type();
				type.setIdtype(rs.getInt(1));
				type.setNom(rs.getString(2));

				liste.add(type);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public Type get(int idtype) {
		String sql="select * from type where idtype=?";
		Type type = null;
		try {
				db.initPrepar(sql);
				db.getPstm().setInt(1, idtype);
				rs=db.executeSelect();
				if(rs.next()){
					type = new Type();
					type.setIdtype(rs.getInt(1));
					type.setNom(rs.getString(2));


				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}

}
