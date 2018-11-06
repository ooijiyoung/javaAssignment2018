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
	@FXML
	private Button btnLogout;
	
	@FXML
	private String variable;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void initVariables(String variable) {
	    this.variable = variable;
	}
	
	public void cmdQuiz(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Quiz.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	public void cmdRevision(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Revision.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	public void cmdResults(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Result.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	public void cmdProfile(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Profile.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	public void cmdRanking(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Ranking.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	public void cmdLogout(ActionEvent event) throws IOException{
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Login.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

}
