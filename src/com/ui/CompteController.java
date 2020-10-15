package com.ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.dao.AgenceImpl;
import com.dao.ClientImpl;
import com.dao.CompteImpl;
import com.dao.EpmloyeImpl;
import com.dao.IAgence;
import com.dao.IClient;
import com.dao.ICompte;
import com.dao.IEmploye;
import com.dao.IType;
import com.dao.IUser;
import com.dao.TypeImpl;
import com.dao.UserImpl;
import com.entities.Agence;
import com.entities.Client;
import com.entities.Compte;
import com.entities.CompteCourant;
import com.entities.CompteEpargne;
import com.entities.Employe;
import com.entities.Type;
import com.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import tools.Notification;
import tools.Outils;

public class CompteController implements Initializable {

    @FXML
    private JFXTextField solde_txt;

    @FXML
    private JFXTextField code_txt;

    @FXML
    private JFXComboBox<Client> client_cbx;

    @FXML
    private JFXDatePicker date_txt;

    @FXML
    private TableView<Compte> compte_table;

    @FXML
    private TableColumn<Compte, String> code_column;

    @FXML
    private TableColumn<Compte, LocalDate> date_column;

    @FXML
    private TableColumn<Compte, Double> solde_column;

    @FXML
    private TableColumn<Compte, Client> client_Column;

    @FXML
    private TableColumn<Compte, Agence> agence_column;

    @FXML
    private TableColumn<Compte, Type> type_column;

    @FXML
    private JFXComboBox<Agence> agence_cbx;

    @FXML
    private JFXButton valider_btn;

    @FXML
    private JFXButton retour_btn;

    @FXML
    private JFXComboBox<Type> type_cbx;
    private ObservableList<Client> cli;
    private ObservableList<Agence> ag;
    private ObservableList<Type> ty;
    private ICompte ico = new CompteImpl();
    private IAgence agdao = new AgenceImpl();
    private IClient clidao = new ClientImpl();
    private IType tydao = new TypeImpl();
    @FXML
    void retour(ActionEvent event) throws IOException {
    	Outils.load(event, "/application/Accueil.fxml");

    }

    @FXML
    void tableClick(MouseEvent event) {
    	//Recuperation de la ligne selectionnee
    	Compte c = compte_table.getSelectionModel().getSelectedItem();
    	//Affecttation des valeur aux de saisie
    	code_txt.setText(c.getCodeCompte().toString());
    	//date_txt.setValue(c.getDateCreation()+"");
    	solde_txt.setText(c.getSolde()+"");
    	client_cbx.getSelectionModel().select(c.getClient());
    	agence_cbx.getSelectionModel().select(c.getAgence());
    	type_cbx.getSelectionModel().select(c.getType());
    	gestionButtonform();
    }
    private String codeCompte;
    @FXML
    void valider(ActionEvent event) {
    	//Compte c = new Compte();
    	double decouvet =0.0;
    	 double taux=0.0;
    	/*try {

    		//ICompte ico = new CompteImpl();
    		Compte c= new Compte();
    		c.setCodeCompte(code_txt.getText());
    		//c.setDateCreation( date_txt.getValue());
    		c.setSolde(Double.parseDouble(solde_txt.getText().toString()));
    		c.setClient(client_cbx.getSelectionModel().getSelectedItem());
    		c.setAgence(agence_cbx.getSelectionModel().getSelectedItem());
    		c.setType(type_cbx.getSelectionModel().getSelectedItem());
    		if(type_cbx.getValue().toString().equalsIgnoreCase("Compte_Courant") ){
    			CompteCourant co=new CompteCourant();
    			decouvet=co.getDecouvert();
    			int  ok =ico.add(c);
    			int ok1=ico.addTaxeC(decouvet);
        		if(ok !=0 && ok1 !=0){
        			Notification.NotifSucces("Succes", "Données Ajouter");
        			loadTable();
        		}else{
        			Notification.NotifError("Erreur", "Données non Ajouter");
        		}

    		}
    		if(type_cbx.getValue().toString().equalsIgnoreCase("Compte_Epargne") ){
    			CompteEpargne coe=new CompteEpargne();
    			taux=coe.getTaux();
    			int  ok =ico.add(c);
    			int ok2=ico.addTaxeEp(taux);
        		if(ok !=0 && ok2 !=0){
        			Notification.NotifSucces("Succes", "Données Ajouter");
        	    	loadTable();
        		}else{
        			Notification.NotifError("Erreur", "Données non Ajouter");
        		}
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	 /////////////////le bon------------
    	 /*try {
     		Compte c = new Compte();
     		c.setCodeCompte(code_txt.getText());
     		c.setSolde(Double.parseDouble(solde_txt.getText().toString()));
     		c.setClient(client_cbx.getSelectionModel().getSelectedItem());
     		c.setAgence(agence_cbx.getSelectionModel().getSelectedItem());
     		c.setType(type_cbx.getSelectionModel().getSelectedItem());
     		int ok =ico.add(c);
     		if(ok !=0){
     			Notification.NotifSucces("Succes", "Données Ajouter");
     		}else{
     			Notification.NotifError("Erreur", "Données non Ajouter");
     		}

 		} catch (Exception e) {
 			e.printStackTrace();
 		}
     	loadTable();
     	*/
    	 try {
      		Compte c = new Compte();
      		c.setCodeCompte(code_txt.getText());
      		c.setSolde(Double.parseDouble(solde_txt.getText().toString()));
      		c.setClient(client_cbx.getSelectionModel().getSelectedItem());
      		c.setAgence(agence_cbx.getSelectionModel().getSelectedItem());
      		c.setType(type_cbx.getSelectionModel().getSelectedItem());
      		if(c!= null){
      			if(type_cbx.getValue().getNom().equalsIgnoreCase("Compte_Courant")){
      				int ok =ico.add(c);
      				//CompteCourant co=new CompteCourant();
      				//decouvet=co.getDecouvert();
        			int ok1=ico.addTaxeC(decouvet);
              		if(ok !=0 && ok1!=0){
              			Notification.NotifSucces("Succes", "Données Ajouter");
              		}else{
              			Notification.NotifError("Erreur", "Données non Ajouter");
              		}
      			}
      			if(type_cbx.getValue().getNom().equalsIgnoreCase("Compte_Epargne")){
      				int ok =ico.add(c);
      				//CompteEpargne coe=new CompteEpargne();
        			//taux=coe.getTaux();
        			int ok1=ico.addTaxeEp(taux);
              		if(ok !=0 && ok1!=0){
              			Notification.NotifSucces("Succes", "Données Ajouter");
              		}else{
              			Notification.NotifError("Erreur", "Données non Ajouter");
              		}
      			}


      		}
    	 } catch (Exception e) {
   			e.printStackTrace();
   		}
       	loadTable();

    }



    private void gestionButtonform(){
    	valider_btn.setDisable(true);
    	/*annuler_btn.setText("Actualiser");
    	supprimer_btn.setDisable(false);
    	modifier_btn.setDisable(false);*/
    }

    private void gestionButtontable(){
    	valider_btn.setDisable(false);
    	/*annuler_btn.setText("Actualiser");
    	supprimer_btn.setDisable(true);
    	modifier_btn.setDisable(true);*/
    }
    private void loadTable(){
    	code_column.setCellValueFactory(new PropertyValueFactory<>("codeCompte"));
    	date_column.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
    	solde_column.setCellValueFactory(new PropertyValueFactory<>("solde"));
    	client_Column.setCellValueFactory(new PropertyValueFactory<>("client"));
    	agence_column.setCellValueFactory(new PropertyValueFactory<>("agence"));
    	type_column.setCellValueFactory(new PropertyValueFactory<>("type"));
    	ObservableList<Compte> cs = FXCollections.observableArrayList();
    	try {
			ico.liste().stream()
				.forEach(c-> cs.add(c));
			compte_table.setItems(cs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	compte_table.setItems(cs);
    	//param_lb.setText(Employe.param_connexion);
    }
    private void loadCombo(){
    	cli = FXCollections.observableArrayList();
    	Client cl = new Client();
    	cl.setIdCli(1);
    	cl.setNomCli("--");
    	cl.setPrenomCli("faites votre choix");
      	cli.add(cl);
    	try {
    		clidao.liste().stream()
			.forEach(e->{
				cli.add(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
    	client_cbx.setItems(cli);
    	//selection de la premiere entree du combobox(faites votre choix)
    	client_cbx.getSelectionModel().selectFirst();

    }
    private void loadComboA(){
    	ag = FXCollections.observableArrayList();
    	Agence a = new Agence();
    	a.setIdA(1);
    	a.setNomA("--");
    	a.setAdressA("faites votre choix");
      	ag.add(a);
    	try {
    		agdao.liste().stream()
			.forEach(e->{
				ag.add(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
    	agence_cbx.setItems(ag);
    	//selection de la premiere entree du combobox(faites votre choix)
    	agence_cbx.getSelectionModel().selectFirst();

    }
    private void loadComboT(){
    	ty = FXCollections.observableArrayList();
    	Type t = new Type();
    	t.setIdtype(1);
    	t.setNom("--");
    	t.setNom("faites votre choix");
      	ty.add(t);
    	try {
    		tydao.liste().stream()
			.forEach(e->{
				ty.add(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
    	type_cbx.setItems(ty);
    	//selection de la premiere entree du combobox(faites votre choix)
    	type_cbx.getSelectionModel().selectFirst();

    }
   /* @FXML
	private void loadCmbType() {
    	type_cbx.getItems().add("Faites votre choix");
    	type_cbx.getItems().addAll("Compte_Courant","Compte_Epargne","Compte_Bloque");
    	type_cbx.getSelectionModel().selectFirst();
    }*/

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	loadTable();
	loadCombo();
	loadComboA();
	loadComboT();

}
}

