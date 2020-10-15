package com.ui;
import java.io.IOException;


import com.dao.EpmloyeImpl;

import com.dao.IEmploye;
import com.dao.IUser;

import com.dao.UserImpl;

import com.entities.Employe;
import com.entities.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import tools.Notification;
import tools.Outils;

public class AdministrationControlleur {
	 @FXML
	    private TextField email_txt;

	    @FXML
	    private TextField password_txt;

	    @FXML
	    private ComboBox<String> libelle_cbx;

	    @FXML
	    private ComboBox<Employe> emp_cbx;
	    private ObservableList<Employe> emps;
	    private IUser iu = new UserImpl();

	    private IEmploye empdao = new EpmloyeImpl();
	    @FXML
	    private Button valider_btn;
	    @FXML
	    private Button employeur_btn;
	    @FXML
	    private Button modifier_btn;

	    @FXML
	    private Button annuler_btn;

	    @FXML
	    private Button supprimer_btn;

	    @FXML
	    private Button retour_btn;

	    @FXML
	    private TableView<User> admin_table;

	    @FXML
	    private TableColumn<User, Integer> id_column;

	    @FXML
	    private TableColumn<User, String> email_column;

	    @FXML
	    private TableColumn<User, String> password_column;

	    @FXML
	    private TableColumn<User, String> libelle_column;

	    @FXML
	    private TableColumn<User, Employe> empl_column;

	    @FXML
	    private Label param_lb;

	    @FXML
	    void annuler(ActionEvent event) {
	    	gestionButtontable();
	    	email_txt.setText("");
	    	password_txt.setText("");
	    	libelle_cbx.getSelectionModel().selectFirst();
	    }
	    private int id;
	    @FXML
	    void modifier(ActionEvent event) {
	    	try {
	    		User u = new User();
	    		u.setId(id);
	    		u.setEmail(email_txt.getText());
	    		u.setPassword(password_txt.getText());
	    		u.setLibelle(libelle_cbx.getValue().toString());
	    		//cu.setMat(new EmployeDBImp().get(Employe.matEmp));
	    		u.setMat(emp_cbx.getSelectionModel().getSelectedItem());
	    		int  ok =iu.update(u);
	    		if(ok !=0){
	    			Notification.NotifSucces("Succes", "Données Modifier");
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
	    void retour(ActionEvent event) throws IOException {
	    	Outils.load(event, "/application/Accueil.fxml");
	    }

	    @FXML
	    void supprimer(ActionEvent event) {
	    	try {
	    		 int ok = iu.delete(id);
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
	    	User u = admin_table.getSelectionModel().getSelectedItem();
	    	//Affecttation des valeur aux de saisie
	    	id = u.getId();
	    	email_txt.setText(u.getEmail().toString());
	    	password_txt.setText(u.getPassword().toString());
	    	libelle_cbx.getSelectionModel().select(u.getLibelle().toString());
	    	emp_cbx.getSelectionModel().select(u.getMat());
	    	gestionButtonform();
	    }

	    @FXML
	    void valider(ActionEvent event) {
	    	try {
	    		User u = new User();

	    		u.setEmail(email_txt.getText());
	    		u.setPassword(password_txt.getText());
	    		u.setLibelle(libelle_cbx.getValue().toString());
	    		//cu.setMat(new EmployeDBImp().get(Employe.matEmp));
	    		u.setMat(emp_cbx.getSelectionModel().getSelectedItem());
	    		int  ok =iu.add(u);
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
	    	id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
	    	email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
	    	password_column.setCellValueFactory(new PropertyValueFactory<>("password"));
	    	libelle_column.setCellValueFactory(new PropertyValueFactory<>("libelle"));
	    	empl_column.setCellValueFactory(new PropertyValueFactory<>("mat"));

	    	ObservableList<User> us = FXCollections.observableArrayList();
	    	try {

				iu.liste().stream()
					.forEach(u-> us.add(u));
				admin_table.setItems(us);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	admin_table.setItems(us);
	    	param_lb.setText(Employe.param_connexion);
	    }
	    private void loadCombo(){
	    	emps = FXCollections.observableArrayList();
	    	Employe emp = new Employe();
	    	emp.setNom("--");
	    	emp.setPrenom("faites votre choix");
	      	emps.add(emp);
	    	try {
	    		empdao.liste().stream()
				.forEach(e->{
					emps.add(e);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	emp_cbx.setItems(emps);
	    	//selection de la premiere entree du combobox(faites votre choix)
	    	emp_cbx.getSelectionModel().selectFirst();

	    }
	    @FXML
	    private void initialize(){
	    	loadTable();
	    	loadCombo();
	    	loadCmblibelle();
	    }
	    @FXML
		private void loadCmblibelle() {
	    	libelle_cbx.getItems().add("Faites votre choix");
	    	libelle_cbx.getItems().addAll("Caissiere","Reponsable");
	    	libelle_cbx.getSelectionModel().selectFirst();

		}
	    @FXML
	    void employeur(ActionEvent event) throws IOException {
	    	Outils.load(event, "/com/ui/Employeur.fxml");
	    }
	    @FXML
	    private Button agence_btn;

	    @FXML
	    void agence(ActionEvent event) throws IOException {
	    	Outils.load(event, "/com/ui/Agence.fxml");
	    }
}
