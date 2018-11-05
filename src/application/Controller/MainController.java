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

public class MainController implements Initializable  {
	
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button btnQuiz;
	@FXML
	private Button btnRevision;
	@FXML
	private Button btnResults;
	@FXML
	private Button btnProfile;
	@FXML
	private Button btnRanking;

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void goToQuiz(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Quiz.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

}
