package com.ui;


import com.dao.CompteImpl;
import com.dao.ICompte;
import com.dao.IUser;
import com.dao.UserImpl;
import com.entities.Client;
import com.entities.Compte;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ConsulteCompteController {

    @FXML
    private JFXTextField codeCompte_txt;

    @FXML
    private JFXButton ok_btn;

    @FXML
    private JFXButton new_btn;

    @FXML
    void naw(ActionEvent event) {
    	
    }

    @FXML
    void ok(ActionEvent event) {
    	String compte = codeCompte_txt.getText();
    	Compte c = new Compte();
    	ICompte ic = new CompteImpl();
    	Compte co = ic.get(compte);
    }

}
