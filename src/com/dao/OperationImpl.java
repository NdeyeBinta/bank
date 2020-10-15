package com.dao;

import java.sql.ResultSet;
import java.util.List;

import com.entities.Compte;
import com.entities.Operation;







public class OperationImpl implements IOperation {
	private DB db;
	private int ok;
	private ResultSet rs;
	private boolean trouve;
	public OperationImpl()  {
		db = new DB();
	}
	@Override
	public List<Operation> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Retrait(String codeCompte, double montant) {
		String sql = "UPDATE compte SET solde = solde-'"+montant+"'  WHERE codeCompte = ? ";
		trouve = false;
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setString(1, codeCompte);
			//execution de la requete
			ok = db.executeMaj();
			if(ok!=0) {
				trouve = true;
			}
		} catch (Exception ex) {
			trouve = false;
			ex.printStackTrace();
		}
		return trouve;

	}

	@Override
	public boolean Depot(String codeCompte, double montant) {
		String sql = "UPDATE compte SET solde = solde+'"+montant+"'  WHERE codeCompte = ? ";
		trouve = false;
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setString(1, codeCompte);
			//execution de la requete
			ok = db.executeMaj();
			if(ok!=0) {
				trouve = true;
			}
		} catch (Exception ex) {
			trouve = false;
			ex.printStackTrace();
		}
		return trouve;
	}

	@Override
	public boolean Virement(String codeCompte, double montant) {
		String sql="UPDATE compte SET solde = solde + '"+montant+"' WHERE codeCompte=? ";
		trouve = false;
		try {
			//initialise la requete sql
			db.initPrepar(sql);
			/*passage de valeur*/
			db.getPstm().setString(1, codeCompte);
			//execution de la requete
			ok = db.executeMaj();
			if(ok!=0) {
				trouve = true;
			}
		} catch (Exception ex) {
			trouve = false;
			ex.printStackTrace();
		}
		return trouve;
	}

	@Override
	public Operation getopId(String codeCompte) {
		String sql="SELECT numero  FROM operation where codeCompte ='"+codeCompte+"' ";
		Operation operation=null;
		try {
				db.initPrepar(sql);
				rs=db.executeSelect();
				while(rs.next()){
					operation=new Operation();
					operation.setNumero(rs.getInt("numero"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operation;

	}

	@Override
	public int add(Operation operation) {
		String sql="insert into operation values(null,null,?,?,?,?,?)";
		ok=0;
		try {
			db.initPrepar(sql);
			//db.getPstm().setObject(1, operation.getDateOperation());
			db.getPstm().setDouble(1, operation.getMontant());
			db.getPstm().setString(2, operation.getTypeop());
			db.getPstm().setString(3, operation.getCompte().getCodeCompte());
			db.getPstm().setInt(4,operation.getEmploye().getMat());
			db.getPstm().setInt(5, operation.getAgence().getIdA());
			ok=db.executeMaj();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public Operation get(int numero) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Compte checkCompte(String codeCompte) {
		String sql="select * from compte where codeCompte=?";
		Compte compte=null;
		try {
				db.initPrepar(sql);
				db.getPstm().setString(1, codeCompte);
				rs=db.executeSelect();
				while(rs.next()){
					compte=new Compte();
					compte.setCodeCompte(rs.getString(1));
					compte.setSolde(rs.getDouble(3));

				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte;
	}

}
