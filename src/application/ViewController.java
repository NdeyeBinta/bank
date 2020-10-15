package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import tools.Outils;

public class ViewController {

    @FXML
    void admin(ActionEvent event) throws IOException {
    	Outils.load(event,"/application/Main.fxml");
    }

    @FXML
    void caisse(ActionEvent event) throws IOException {
    	Outils.load(event,"/application/MainPourC.fxml");
    }

    @FXML
    void responsable(ActionEvent event) throws IOException {
    	Outils.load(event,"/application/MainPourR.fxml");
    }

    @FXML
    void respon(ActionEvent event) throws IOException {
    	Outils.load(event,"/application/MainR.fxml");
    }
}