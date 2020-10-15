package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entities.Compte;


public class CompteImpl implements ICompte{
	private DB db;
	private int ok;
	private ResultSet rs;
	public CompteImpl()  {
		db = new DB();
	}
	@Override
	public int add(Compte compte) {
		String sql="insert into compte values(?,null,?,?,?,?)";
		ok=0;
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, compte.getCodeCompte());
			//db.getPstm().setObject(2, compte.getDateCreation());
			db.getPstm().setDouble(2, compte.getSolde());
			db.getPstm().setInt(3, compte.getClient().getIdCli());
			db.getPstm().setInt(4, compte.getAgence().getIdA());
			db.getPstm().setInt(5,compte.getType().getIdtype());
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int addTaxeEp(double taux) {
		String sql = "INSERT INTO taxe VALUES(null,?,null)";
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setDouble(1, taux);
			//execution de la requete
			ok = db.executeMaj();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int addTaxeC(double decouvet) {
		String sql = "INSERT INTO taxe VALUES(null,null,?)";
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setDouble(1, decouvet);
			//execution de la requete
			ok = db.executeMaj();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public int delete(String codeCompte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Compte> liste() {
		String sql="select * from compte ";
		List<Compte> comptes = new ArrayList<Compte>();
		try {
				db.initPrepar(sql);
				rs=db.executeSelect();
				while(rs.next()){
					Compte compte = new Compte();
					compte.setCodeCompte(rs.getString(1));
					compte.setDateCreation(rs.getDate(2).toLocalDate());
					compte.setSolde(rs.getDouble(3));
					compte.setClient(new ClientImpl().get(rs.getInt(4)));
					compte.setAgence(new AgenceImpl().get(rs.getInt(5)));
					compte.setType(new TypeImpl().get(rs.getInt(6)));
					comptes.add(compte);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public Compte get(String codeCompte) {
		String sql="select solde from compte where codeCompte=?";
		Compte compte=null;
		try {
				db.initPrepar(sql);
				rs=db.executeSelect();
				while(rs.next()){
					compte=new Compte();
					compte.setCodeCompte(rs.getString(1));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;


	}

}
