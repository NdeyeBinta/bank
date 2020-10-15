package com.ui;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dao.EmployeurImpl;
import com.dao.IEmployeur;

import com.entities.Employeur;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import tools.Notification;
import tools.Outils;
public class EmployeurController implements Initializable {
	@FXML
    private TextField raison_txt;

	  @FXML
	    private TextField adress_txt;

    @FXML
    private TextField nom_txt;

    @FXML
    private TextField numID_txt;

    @FXML
    private TableView<Employeur> employeur_table;

    @FXML
    private TableColumn<Employeur, Integer> id_column;

    @FXML
    private TableColumn<Employeur, String> raison_column;

    @FXML
    private TableColumn<Employeur, String> adress_column;

    @FXML
    private TableColumn<Employeur, String> nom_column;

    @FXML
    private TableColumn<Employeur, Integer> numID_column;

    @FXML
    private Button valider_btn;

    @FXML
    private Button modifier_btn;

    @FXML
    private Button annuler_btn;

    @FXML
    private Button supprimer_btn;

    @FXML
    private Button retour_btn;
    private IEmployeur ie = new EmployeurImpl();
    @FXML
    void annuler(ActionEvent event) {
    	gestionButtontable();
    	raison_txt.setText("");
    	adress_txt.setText("");
    	nom_txt.setText("");
    	numID_txt.setText("");
    }
    private int idEmplCli;
    @FXML
    void modifier(ActionEvent event) {
    	try {
    		Employeur emp = new Employeur();
    		emp.setIdEmplCli(idEmplCli);
    		emp.setRaisonSocial(raison_txt.getText());
    		emp.setAdressEmplCli(adress_txt.getText());
    		emp.setNomEmplCli(nom_txt.getText());
    		numID_txt.setText(emp.getNumIDEmplCli()+"");
    		int  ok =ie.update(emp);
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
    void retour(ActionEvent event) throws IOException {
    	Outils.load(event, "/application/Accueil.fxml");
    }

    @FXML
    void supprimer(ActionEvent event) {
    	try {
        	int  ok =ie.delete(idEmplCli);
        	if(ok!=0){
        		Notification.NotifSucces("Succes", "donnee supprimer");
        		}else{
            		Notification.NotifError("Error", "donnee  non supprimer");
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
    	Employeur em = employeur_table.getSelectionModel().getSelectedItem();
    	//Affecttation des valeur aux de saisie
    	idEmplCli = em.getIdEmplCli();
    	raison_txt.setText(em.getRaisonSocial().toString());
    	adress_txt.setText(em.getAdressEmplCli().toString());
    	nom_txt.setText(em.getNomEmplCli().toString());
    	numID_txt.setText(em.getNumIDEmplCli()+"");

    	gestionButtonform();
    }

    @FXML
    void valider(ActionEvent event) {
    	try {
    		Employeur emp = new Employeur();

    		emp.setRaisonSocial(raison_txt.getText());
    		emp.setAdressEmplCli(adress_txt.getText());
    		emp.setNomEmplCli(nom_txt.getText());
    		emp.setNumIDEmplCli(Integer.parseInt(numID_txt.getText().toString()));
    		int  ok =ie.add(emp);
    		if(ok !=0){
    			Notification.NotifSucces("Succes", "Données ajoutées");
    		}else{
    			Notification.NotifError("Erreur", "Données non ajoutée");
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
    	id_column.setCellValueFactory(new PropertyValueFactory<>("idEmplCli"));
    	raison_column.setCellValueFactory(new PropertyValueFactory<>("raisonSocial"));
    	adress_column.setCellValueFactory(new PropertyValueFactory<>("adressEmplCli"));
    	nom_column.setCellValueFactory(new PropertyValueFactory<>("nomEmplCli"));
    	numID_column.setCellValueFactory(new PropertyValueFactory<>("numIDEmplCli"));

    	ObservableList<Employeur> emp = FXCollections.observableArrayList();
    	try {

			ie.liste().stream()
				.forEach(e-> emp.add(e));
			employeur_table.setItems(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	employeur_table.setItems(emp);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadTable();

	}

}
