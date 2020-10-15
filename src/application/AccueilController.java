package application;




import java.io.IOException;

import com.entities.Employe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tools.Outils;


public class AccueilController {
	@FXML
    private Label params;

    @FXML
    private Button administration_btn;

    @FXML
    private Button client_btn;

    @FXML
    private Button compte_btn;

    @FXML
    private Button operation_btn;

    @FXML
    void administration(ActionEvent event) throws IOException {
    	Outils.load(event,"/com/ui/Administration.fxml");
    }

    @FXML
    void client(ActionEvent event) throws IOException {
    	Outils.load(event,"/com/ui/Client.fxml");
    }

    @FXML
    void compte(ActionEvent event) throws IOException {
    	Outils.load(event,"/com/ui/ConsulteCompte.fxml");
    }

    @FXML
    void operation(ActionEvent event) throws IOException {
    	Outils.load(event,"/com/ui/Operation.fxml");
    }
    @FXML
    void retour(ActionEvent event) throws IOException {
    	Outils.load(event,"/application/Main.fxml");
    }
    public void initialize() {
		params.setText(Employe.param_connexion);

	}
}
