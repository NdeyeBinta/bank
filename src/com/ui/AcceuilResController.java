package com.ui;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import tools.Outils;
public class AcceuilResController {
	 @FXML
	    private JFXButton client_btn;

	    @FXML
	    private JFXButton operation_btn;

	    @FXML
	    private JFXButton retour_btn;

	    @FXML
	    void client(ActionEvent event) throws IOException {
	    	Outils.load(event, "/com/ui/Client.fxml");
	    }

	    @FXML
	    void operation(ActionEvent event) throws IOException {
	    	Outils.load(event, "/com/ui/Operation.fxml");
	    }

	    @FXML
	    void retour(ActionEvent event) throws IOException {
	    	Outils.load(event, "/com/ui/AcceuilRes.fxml");
	    }

}
