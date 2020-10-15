package application;

import java.io.IOException;

import com.dao.IUser;
import com.dao.UserImpl;
import com.entities.Employe;
import com.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import tools.Notification;
import tools.Outils;

public class MainControllerPourC {
	 @FXML
	    private JFXTextField email_txt;


	 @FXML
	    private JFXPasswordField password_txt;
	    @FXML
	    private JFXButton connexion_btn;

	    @FXML
	    void connexion(ActionEvent event) {
	    	String email = email_txt.getText();
	        String password = password_txt.getText();
	        if(email.equals("") || password.equals("")){
	        	Notification.NotifError("Erreur", "veillez remplir tous les champs");

	        }else{

	        	try{
	        		IUser iu = new UserImpl();
	        		User u =  iu.getLogin(email, password);
	        		if(u !=null){
	    				if(u.getLibelle().equalsIgnoreCase("caissiere"))
	    				{
	    					Notification.NotifSucces("Succées", "utilisateur connue");
	        				Employe.param_connexion = "Bienvenue Mr(s) : " + u.getMat().getPrenom() + " " + u.getMat().getNom();
	        				Employe.matEmp=u.getMat().getMat();
	        				Notification.NotifSucces("Succée", "Utilisateur connue");
	        				Outils.load(event,"/com/ui/Operation.fxml");
	    				}else{
	    					Notification.NotifError("Erreur", "email ou mot de passe incorrecte");
	    				}
	    			}else{
	    				Notification.NotifError("Erreur", "email ou mot de passe incorrecte");
	    			}
	        	}catch(IOException e){
	        		e.printStackTrace();
	        	}
	        }
	    }

	    @FXML
	    void retour(ActionEvent event) throws IOException {
	    	Outils.load(event,"/application/View.fxml");
	    }
}
