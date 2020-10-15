package com.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dao.ClientImpl;
import com.dao.EmployeurImpl;

import com.dao.IClient;

import com.dao.IEmployeur;
import com.entities.Client;

import com.entities.Employeur;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tools.Notification;
import tools.Outils;

public class ClientController implements Initializable{

    @FXML
    private TextField nomCli_txt;

    @FXML
    private TextField prenomCli_txt;

    @FXML
    private TextField adressCli_txt;

    @FXML
    private TextField emailCli_txt;

    @FXML
    private TextField telCli_txt;

    @FXML
    private TextField salaire_txt;

    @FXML
    private TextField profession_txt;

    @FXML
    private TextField numID_txt;

    @FXML
    private ComboBox<Employeur> employ_cbx;

    @FXML
    private Button retour_btn;

    @FXML
    private Button supprimer_btn;

    @FXML
    private Button modifier_btn;

    @FXML
    private Button annuler_btn;

    @FXML
    private Button valider_btn;

    @FXML
    private TableView<Client> client_table;

    @FXML
    private TableColumn<Client, Integer> idCli_Column;

    @FXML
    private TableColumn<Client, String> nomCli_Column;

    @FXML
    private TableColumn<Client, String> prenomCli_Column;

    @FXML
    private TableColumn<Client, String> adressCli_Column;

    @FXML
    private TableColumn<Client, String> emailCli_Column;

    @FXML
    private TableColumn<Client, String> telCli_Column;

    @FXML
    private TableColumn<Client, Double> salaire_Column;

    @FXML
    private TableColumn<Client, String> profession_Column;

    @FXML
    private TableColumn<Client, Integer> numID_Column;

    @FXML
    private TableColumn<Client, Employeur> employeur_Column;
    private ObservableList<Employeur> employs;
    private IClient ic = new ClientImpl();
    private IEmployeur empldao=new EmployeurImpl() ;

    @FXML
    void annuler(ActionEvent event) {
    	gestionButtontable();
    	nomCli_txt.setText("");
    	prenomCli_txt.setText("");
    	adressCli_txt.setText("");
    	emailCli_txt.setText("");
    	telCli_txt.setText("");
    	salaire_txt.setText("");
    	profession_txt.setText("");
    	numID_txt.setText("");
    	employ_cbx.getSelectionModel().selectFirst();
    }
    @FXML
    void retour(ActionEvent event) throws IOException {
    	Outils.load(event, "/application/Accueil.fxml");

    }
    private int idCli;
    @FXML
    void modifier(ActionEvent event) {
    	try {
    		Client c = new Client();
    		c.setIdCli(idCli);;
    		c.setNomCli(nomCli_txt.getText());
    		c.setPrenomCli(prenomCli_txt.getText());
    		c.setAdressCli(adressCli_txt.getText());
    		c.setEmailCli(emailCli_txt.getText());
    		c.setTelCli(Integer.parseInt(telCli_txt.getText().toString()));
    		c.setSalaire(Double.parseDouble(salaire_txt.getText().toString()));
    		c.setProfession(profession_txt.getText());
    		c.setNumID(Integer.parseInt(numID_txt.getText().toString()));
    		c.setEmployeur(employ_cbx.getSelectionModel().getSelectedItem());
    		int ok =ic.update(c);
    		if(ok !=0){
    			Notification.NotifSucces("Succes", "Données modifier");
    		}else{
    			Notification.NotifError("Erreur", "Données non modifier");
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}
    	loadTable();
    	annuler(event);
    }

    @FXML
    void supprimer(ActionEvent event) {
    	try {
      		 int ok = ic.delete(idCli);
      		if(ok !=0){
      			Notification.NotifSucces("Succes", "Données suprimer");
      		}else{
      			Notification.NotifError("Erreur", "Données non suprimer");
      		}

   		} catch (Exception e) {
   			e.printStackTrace();
   		}
      	loadTable();
      	annuler(event);
    }

    @FXML
    void tableClick(MouseEvent event) {
    	//Recuperation de la ligne selectionnee
    	Client c = client_table.getSelectionModel().getSelectedItem();
    	//Affecttation des valeur aux de saisie
    	idCli = c.getIdCli();
    	nomCli_txt.setText(c.getNomCli().toString());
    	prenomCli_txt.setText(c.getPrenomCli().toString());
    	adressCli_txt.setText(c.getAdressCli().toString());
    	emailCli_txt.setText(c.getEmailCli().toString());
    	telCli_txt.setText(c.getTelCli()+"");
    	salaire_txt.setText(c.getEmailCli().toString());
    	profession_txt.setText(c.getProfession().toString());
    	numID_txt.setText(c.getNumID()+"");
    	employ_cbx.getSelectionModel().select(c.getEmployeur());
    	gestionButtonform();
    }

    @FXML
    void valider(ActionEvent event) {
    	try {
    		Client c = new Client();
    		c.setIdCli(idCli);
    		c.setNomCli(nomCli_txt.getText());
    		c.setPrenomCli(prenomCli_txt.getText());
    		c.setAdressCli(adressCli_txt.getText());
    		c.setEmailCli(emailCli_txt.getText());
    		c.setTelCli(Integer.parseInt(telCli_txt.getText().toString()));
    		c.setSalaire(Double.parseDouble(salaire_txt.getText().toString()));
    		c.setProfession(profession_txt.getText());
    		c.setNumID(Integer.parseInt(numID_txt.getText().toString()));
    		c.setEmployeur(employ_cbx.getSelectionModel().getSelectedItem());
    		int ok =ic.add(c);
    		if(ok !=0){
    			Notification.NotifSucces("Succes", "Données Ajouter");
    		}else{
    			Notification.NotifError("Erreur", "Données non Ajouter");
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}
    	loadTable();
    	annuler(event);
    }
    private void gestionButtonform(){
    	valider_btn.setDisable(true);
    	annuler_btn.setText("Actualiser");
    	supprimer_btn.setDisable(false);
    	modifier_btn.setDisable(false);
    }

    private void gestionButtontable(){
    	valider_btn.setDisable(false);
    	annuler_btn.setText("Actualiser");
    	supprimer_btn.setDisable(true);
    	modifier_btn.setDisable(true);
    }
    private void loadTable(){
    	idCli_Column.setCellValueFactory(new PropertyValueFactory<>("idCli"));
    	nomCli_Column.setCellValueFactory(new PropertyValueFactory<>("nomCli"));
    	prenomCli_Column.setCellValueFactory(new PropertyValueFactory<>("prenomCli"));
    	adressCli_Column.setCellValueFactory(new PropertyValueFactory<>("emailCli"));
    	emailCli_Column.setCellValueFactory(new PropertyValueFactory<>("adressCli"));
    	telCli_Column.setCellValueFactory(new PropertyValueFactory<>("telCli"));
    	salaire_Column.setCellValueFactory(new PropertyValueFactory<>("salaire"));
    	profession_Column.setCellValueFactory(new PropertyValueFactory<>("profession"));
    	numID_Column.setCellValueFactory(new PropertyValueFactory<>("numID"));
    	employeur_Column.setCellValueFactory(new PropertyValueFactory<>("employeur"));

    	ObservableList<Client> cs = FXCollections.observableArrayList();
    	try {

			ic.liste().stream()
				.forEach(c-> cs.add(c));
			client_table.setItems(cs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	client_table.setItems(cs);
    	//param_lb.setText(Employe.param_connexion);
    }
    private void loadCombo(){
    	employs = FXCollections.observableArrayList();
    	Employeur empl = new Employeur();
    	empl.setNomEmplCli("--");
    	empl.setRaisonSocial("faites votre choix");
    	employs.add(empl);
    	try {
    		empldao.liste().stream()
			.forEach(e->{
				employs.add(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
    	employ_cbx.setItems(employs);
    	//selection de la premiere entree du combobox(faites votre choix)
    	employ_cbx.getSelectionModel().selectFirst();

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadCombo();
		loadTable();

	}
	  @FXML
	    void compte(ActionEvent event) throws IOException {
		  Outils.load(event, "/com/ui/Compte.fxml");
	    }
	/*private void loadTable(){
		try {
	    	ObservableList<Client> cs = FXCollections.observableArrayList(ic.liste());
			//ic.liste().stream()
			//	.forEach(c-> cs.add(c));
			client_table.setItems(cs);
			idCli_Column.setCellValueFactory(new PropertyValueFactory<>("idCli"));
	    	nomCli_Column.setCellValueFactory(new PropertyValueFactory<>("nomCli"));
	    	prenomCli_Column.setCellValueFactory(new PropertyValueFactory<>("prenomCli"));
	    	adressCli_Column.setCellValueFactory(new PropertyValueFactory<>("emailCli"));
	    	emailCli_Column.setCellValueFactory(new PropertyValueFactory<>("adressCli"));
	    	telCli_Column.setCellValueFactory(new PropertyValueFactory<>("telCli"));
	    	salaire_Column.setCellValueFactory(new PropertyValueFactory<>("salaire"));
	    	profession_Column.setCellValueFactory(new PropertyValueFactory<>("profession"));
	    	numID_Column.setCellValueFactory(new PropertyValueFactory<>("numID"));
	    	employeur_Column.setCellValueFactory(new PropertyValueFactory<>("idEmpCli"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//param_lb.setText(Employe.param_connexion);
    }*/
}
