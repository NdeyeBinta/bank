package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.User;


public class UserImpl  implements IUser{
	private DB db;
	private int ok;
	private ResultSet rs;
	public UserImpl() {
		db = new DB();
	}
	@Override
	public int add(User user) {
		ok=0;
		String sql = "INSERT INTO user VALUES(null,?,?,?,?)";
		try {
			db=new DB();
			db.initPrepar(sql);
			db.getPstm().setString(1,user.getEmail());
			db.getPstm().setString(2,user.getPassword());
			db.getPstm().setString(3,user.getLibelle());
			db.getPstm().setInt(4,user.getMat().getMat());
			ok = db.executeMaj();


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(int id) {
		ok=0;
		String sql = "DELETE FROM user where id=?";
		try {
			db=new DB();
			db.initPrepar(sql);
			db.getPstm().setInt(1,id);
			ok = db.executeMaj();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int update(User u) {
		ok=0;
		String sql = "update user set email=? ,password=? ,libelle=? ,mat=? where id=?";
		try
		{
			db=new DB();
			db.initPrepar(sql);
			db.getPstm().setString(1,u.getEmail());
			db.getPstm().setString(2, u.getPassword());
			db.getPstm().setString(3, u.getLibelle());
			db.getPstm().setInt(4, u.getMat().getMat());
			db.getPstm().setInt(5, u.getId());
			ok = db.executeMaj();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<User> liste() {
		List<User> liste = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setLibelle(rs.getString(4));
				u.setMat(new EpmloyeImpl().get(rs.getInt(5)));

				liste.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getLogin(String email, String password) {
		User u = null;
		String sql = "SELECT * FROM user WHERE email= ? AND password= ?";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, email);
			db.getPstm().setString(2,password);
			ResultSet rs = db.executeSelect();
			while(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setLibelle(rs.getString(4));
				u.setMat(new EpmloyeImpl().get(rs.getInt(5)));
			}
			rs.close();
			//db.closeConne;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;

	}

}
