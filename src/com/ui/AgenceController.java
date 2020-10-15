package com.ui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dao.AgenceImpl;

import com.dao.IAgence;

import com.entities.Agence;

import com.jfoenix.controls.JFXButton;
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

public class AgenceController implements Initializable {
	 @FXML
	    private JFXButton valider_btn;

	    @FXML
	    private JFXButton annuler_btn;

	    @FXML
	    private JFXButton modifier_btn;

	    @FXML
	    private JFXButton supprimer_btn;

	    @FXML
	    private JFXButton retour_btn;

    @FXML
    private JFXTextField nomA_txt;

    @FXML
    private JFXTextField adressA_txt;

    @FXML
    private TableView<Agence> agence_table;

    @FXML
    private TableColumn<Agence, Integer> idA_Column;

    @FXML
    private TableColumn<Agence, String> nomA_Column;

    @FXML
    private TableColumn<Agence, String> adressA_Cloumn;
    private IAgence ia = new AgenceImpl();
    @FXML
    void annuler(ActionEvent event) {
    	gestionButtontable();
    	nomA_txt.setText("");
    	adressA_txt.setText("");
    }

    @FXML
    void modifier(ActionEvent event) {
    	try {
    		Agence a = new Agence();
    		a.setIdA(idA);
    		a.setNomA(nomA_txt.getText());
    		a.setAdressA(adressA_txt.getText());


    		int  ok =ia.update(a);
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
    private int idA;
    @FXML
    void supprimer(ActionEvent event) {
    	try {
        	int  ok =ia.delete(idA);
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
    	Agence ag = agence_table.getSelectionModel().getSelectedItem();
    	//Affecttation des valeur aux de saisie
    	idA = ag.getIdA();
    	nomA_txt.setText(ag.getNomA().toString());
    	adressA_txt.setText(ag.getAdressA().toString());



    	gestionButtonform();
    }

    @FXML
    void valider(ActionEvent event) {
    	try {
    		Agence a = new Agence();
    		a.setIdA(idA);
    		a.setNomA(nomA_txt.getText());
    		a.setAdressA(adressA_txt.getText());


    		int  ok =ia.add(a);
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
    	idA_Column.setCellValueFactory(new PropertyValueFactory<>("idA"));
    	nomA_Column.setCellValueFactory(new PropertyValueFactory<>("nomA"));
    	adressA_Cloumn.setCellValueFactory(new PropertyValueFactory<>("adressA"));


    	ObservableList<Agence> ag = FXCollections.observableArrayList();
    	try {

			ia.liste().stream()
				.forEach(e-> ag.add(e));
			agence_table.setItems(ag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	agence_table.setItems(ag);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadTable();


	}


}
