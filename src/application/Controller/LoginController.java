package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable{
  @FXML
  private AnchorPane rootPane;

  @FXML
  private Button btnLogin;

  @FXML
  void cmdLogin(ActionEvent event) {
  	AnchorPane newRoot;
		try {
			newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
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
