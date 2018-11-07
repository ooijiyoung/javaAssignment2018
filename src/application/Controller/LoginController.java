package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Database.StudentDB;
import application.Model.Comms;

public class LoginController implements Initializable{
  @FXML
  private AnchorPane rootPane;

  @FXML
  private Button btnLogin;
  
  @FXML
  private Button btnRegister;
  
  @FXML
  private TextField tfID;

  @FXML
  private PasswordField pfPassword;

  @FXML
  void cmdLogin(ActionEvent event) {
  	AnchorPane newRoot;
  	StudentDB database = new StudentDB();
  	String stdIC = tfID.getText();
  	String stdPwd = pfPassword.getText();
  	
  	int stdID = database.selectStdIDFromIC(stdIC);
  	if(stdID!=0) {
  		if(database.isPwdCorrectFromStdID(stdID, stdPwd)) {
  			Comms.getInstance().shareVar().setLoggedIn();
  			Comms.getInstance().shareVar().setID(stdID);
  			try {
  				newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
  				rootPane.getChildren().setAll(newRoot);
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}else {
  			System.out.println("incorrect pass");
  		}
  		
  	}else {
  		System.out.println("Invalid Username");
  	}
  	
		
		
  }
  
	@FXML
  void cmdRegister(ActionEvent event) {
  	AnchorPane newRoot;
		try {
			newRoot = FXMLLoader.load(getClass().getResource("../Interface/Register.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
