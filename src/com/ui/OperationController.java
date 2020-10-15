package com.ui;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

import com.dao.AgenceImpl;
import com.dao.ClientImpl;
import com.dao.CompteImpl;
import com.dao.EpmloyeImpl;
import com.dao.IAgence;
import com.dao.IClient;
import com.dao.ICompte;
import com.dao.IEmploye;
import com.dao.IOperation;
import com.dao.IType;
import com.dao.IUser;
import com.dao.OperationImpl;
import com.dao.TypeImpl;
import com.dao.UserImpl;
import com.entities.Agence;
import com.entities.Client;
import com.entities.Compte;
import com.entities.Employe;
import com.entities.Operation;
import com.entities.Type;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import tools.Notification;
import tools.Outils;
public class OperationController implements Initializable {
	 @FXML
	    private JFXTextField codeCompte_txt;

	    @FXML
	    private JFXButton ok_btn;

	    @FXML
	    private JFXDatePicker dateop_txt;

	    @FXML
	    private JFXComboBox<String> typeOp_cbx;

	    @FXML
	    private JFXTextField montant_txt;

	    @FXML
	    private JFXComboBox<Employe> caisse_cbx;

	    @FXML
	    private JFXComboBox<Agence> agence_cbx;

	    @FXML
	    private JFXTextField compteDes_txt;

	    @FXML
	    private JFXButton valider_btn;

	    @FXML
	    private JFXComboBox<Compte> compte_cbx;

	    @FXML
	    private JFXButton retour_btn;

	    private ObservableList<Compte> co;
	    private ObservableList<Agence> ag;
	    private ObservableList<Employe> em;
	    private ICompte ico = new CompteImpl();
	    private IAgence agdao = new AgenceImpl();
	    private IEmploye ie=new EpmloyeImpl();
	    private IOperation opdao = new OperationImpl();
	    @FXML
	    void ok(ActionEvent event) {
	    	ICompte ico = new CompteImpl();
	    	String numero = codeCompte_txt.getText();
	    	Compte c = ico.get(numero);//getIop().checkCompte(numero);
	    	if(c!=null) {
	    		Notification.NotifSucces("verification effectuée avec succés, le compte existe", "succés");
	    	}else {
	    		Notification.NotifSucces("Veuillez créer d'abord un compte", "error");

	    	}

	    }

	    @FXML
	    void retour(ActionEvent event) throws IOException {
	    	Outils.load(event, "/application/MainPourC.fxml");

	    }
	    private int numero;
	    @FXML
	    void valider(ActionEvent event) {
	    	double solde=0;
	    	double montant = 0;

	    	/*try {
	      		Compte c = new Compte();
	      		Operation o = new Operation();
	      		o.setNumero(numero);
	      		o.setCompte(compte_cbx.getSelectionModel().getSelectedItem());
	      		o.setEmploye(caisse_cbx.getSelectionModel().getSelectedItem());
	      		o.setAgence(agence_cbx.getSelectionModel().getSelectedItem());
	      		//o.setDateOperation( dateop_txt.getValue());
	      		o.setTypeop(typeOp_cbx.getSelectionModel().getSelectedItem());
	      		o.setMontant(Double.parseDouble(montant_txt.getText().toString()));
	      		int ok =opdao.add(o);
	      		if(ok !=0 ){
          			Notification.NotifSucces("Succes", "Données Ajouter");
          		}else{
          			Notification.NotifError("Erreur", "Données non Ajouter");
          		}

          		} catch (Exception e) {
	   			e.printStackTrace();
	   		}*/
	    	try {
	      		Compte c = new Compte();
	      		Compte c1 = new Compte();
	      		Operation o = new Operation();
	      		o.setNumero(numero);
	      		o.setCompte(compte_cbx.getSelectionModel().getSelectedItem());
	      		o.setEmploye(caisse_cbx.getSelectionModel().getSelectedItem());
	      		o.setAgence(agence_cbx.getSelectionModel().getSelectedItem());
	      		//o.setDateOperation( dateop_txt.getValue());
	      		o.setTypeop(typeOp_cbx.getSelectionModel().getSelectedItem());
	      		o.setMontant(Double.parseDouble(montant_txt.getText().toString()));
	      		c1=compte_cbx.getValue();
	      		c=opdao.checkCompte(c1.getCodeCompte());
	      		cpt=c;
	    		//System.out.println(solde);
	    		montant  = Double.parseDouble(montant_txt.getText().toString());
	    		String compte = o.getCompte().getCodeCompte();
	      		if(o!= null){
	      			System.out.println(typeOp_cbx.getValue());
	      			System.out.println(c.getSolde());
	      			if(typeOp_cbx.getValue().equalsIgnoreCase("Retrait")  && c.getSolde() >montant ){
	      				int ok =opdao.add(o);
	      				//String compte = compte_cbx.getValue().getCodeCompte();
	      				boolean ok1=opdao.Retrait(compte,montant);
	              		if(ok !=0 && ok1!=false){
	              			Notification.NotifSucces("Succes", "Retrait Effectuer");
	              			creatItextPdf("Retrait");
	              		}else{
	              			Notification.NotifError("Erreur", "Retrait non Effectuer");
	              		}
	      			}
	      			if(typeOp_cbx.getValue().equalsIgnoreCase("Depos")){
	      				int ok =opdao.add(o);
	      				boolean ok1=opdao.Depot(compte,montant);
	              		if(ok !=0 && ok1!=false){
	              			Notification.NotifSucces("Succes", "Depos  Effectuer");
	              			creatItextPdf("Depos");
	              		}else{
	              			Notification.NotifError("Erreur", "Depos non Effectuer");
	              		}
	      			}




					int taxe=200;
					if(typeOp_cbx.getValue().equalsIgnoreCase("Depos")&& montant <5000) {

						Notification.NotifSucces("impossible de fairre un dépot de moins de 5000", "");
				}
					if(typeOp_cbx.getValue().equalsIgnoreCase("Virement")) {
				    	String numero = compteDes_txt.getText();
				    	Compte co = opdao.checkCompte(numero);
				    	if(co!=null) {
				    		int ok =opdao.add(o);
		      				//String compte = compte_cbx.getValue().getCodeCompte();
		      				boolean ok1=opdao.Retrait(compte,montant );
		      				boolean ok3=opdao.Virement(numero, montant);
		      						//vir.getIop().Virement(virement, montant);
		              		if(ok !=0 && ok1!=false && ok3!=false){
		              			Notification.NotifSucces("Succes", "Virement effectué avec succès");
		              			creatItextPdf("Virement");
		              		}else{
		              			Notification.NotifError("Erreur", "le compte destinataire n'existe pas veuillez réessayez");
		              		}
				    	}

					}



	      		}
	    	 } catch (Exception e) {
	   			e.printStackTrace();
	   		}

	    }
	    @FXML
		private void loadComboT() {
	    	typeOp_cbx.getItems().add("Faites votre choix");
	    	typeOp_cbx.getItems().addAll("Retrait","Depos","Virement");
	    	typeOp_cbx.getSelectionModel().selectFirst();

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
	    private void loadCombo(){
	    	co = FXCollections.observableArrayList();
	    	Compte cl = new Compte();

	    	cl.setCodeCompte("--");
	    	cl.setCodeCompte("faites votre choix");
	      	co.add(cl);
	    	try {
	    		ico.liste().stream()
				.forEach(e->{
					co.add(e);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	compte_cbx.setItems(co);
	    	//selection de la premiere entree du combobox(faites votre choix)
	    	compte_cbx.getSelectionModel().selectFirst();

	    }
	    private void loadComboC(){
	    	em = FXCollections.observableArrayList();
	    	Employe emp = new Employe();
	    	emp.setNom("--");
	    	emp.setPrenom("faites votre choix");
	      	em.add(emp);
	    	try {
	    		ie.liste().stream()
				.forEach(e->{
					em.add(e);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	caisse_cbx.setItems(em);
	    	//selection de la premiere entree du combobox(faites votre choix)
	    	caisse_cbx.getSelectionModel().selectFirst();

	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			loadCombo();
			loadComboA();
			loadComboT();
			loadComboC();

		}
		Compte cpt=new Compte();
		Agence cashierId =new Agence();
		  private void creatItextPdf(String op){
		         Document document= new Document(PageSize.A4);
		         try {
		              Random rand = new Random();
		             int  n = rand.nextInt(10000) + 1;
		             String url="C:\\Users\\BINTA\\recu.pdf";
		             PdfWriter.getInstance(document, new  FileOutputStream(url));
		             document.open();

		             document.add(new Paragraph("BIENVENU A Ma  BANQUE",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD,BaseColor.ORANGE)));



		             /**
		              * le Numero de la transaction est numAccount+transType+TRANS
		              * */

		             document.add(new Paragraph("NUMERO DE L'OPERATION :"+cpt.getCodeCompte()+"-"+n+"TRANS",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.GREEN)));
		             document.add(new Paragraph("TYPE DE L'OPERATION "+op));
		             if(op.equalsIgnoreCase("virement")){
		                document.add(new Paragraph("COMPTE VIRE : "+compteDes_txt.getText()));
		             }

		             /**
		              * INFORMATION SUR LE CLIENT
		              */
		             document.add(new Paragraph("NUMERO DU CLIENT : "+cpt.getClient().getNumID()));
		             document.add(new Paragraph("NOM DU CLIENT : "+cpt.getClient().getNomCli()));
		             document.add(new Paragraph("NUMERO DU COMPTE : "+cpt.getCodeCompte()));
		             document.add(new Paragraph("\n"));
		             /**
		              * INFORMATION SUR L'AGENCE
		              */
		             document.add(new Paragraph("NOM DE L'AGENCE : "+agence_cbx.getValue().getNomA()));
		             document.add(new Paragraph("ADRESSE DE L'AGENCE : "+agence_cbx.getValue().getAdressA()));

		             document.add(new Paragraph("\t Date : "+LocalDate.now().toString()));

		             document.add(new Paragraph("\n"));


		             document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));

		               //table
		             document.add(new Paragraph("\n\n"));
		             PdfPTable table =new PdfPTable(3);
		             /**
		              * CELLULE D'UNE ENTETE
		              */
		             PdfPCell cell= new PdfPCell(new Paragraph("pRESENTATION DE L'OPERATION"));
		             cell.setColspan(6);
		             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		             cell.setBackgroundColor(BaseColor.GREEN );
		             cell.setPadding(10.0f);

		             table.addCell(cell);

		              /**
		               * Mes entête
		               */
		             table.addCell("NUMERO");
		             table.addCell("TYPE D'OPERATION");
		             table.addCell("MONTANT");
		             /**
		              * CONTENU DU TABLEAU
		              */
		             table.addCell(cpt.getCodeCompte()+"-"+n+"TRANS");
		             table.addCell(op);
		             table.addCell(montant_txt.getText()+"  XOF");

		             /**
		              * AJOUT DE LA TABLE
		              */
		             document.add(table);
		              document.add(cell);
		             document.close();
		             Desktop.getDesktop().open(new File(url));
		         } catch (Exception e) {
		         }
		     }

}
