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
import application.Interface.AlertBox;
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
	
	public void cmdQuiz(ActionEvent event) {
		try {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Quiz.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (Exception e) {
			AlertBox.exceptionAlert(e);
		}
		
	}
	
	public void cmdRevision(ActionEvent event){
		try {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Revision.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (Exception e) {
			AlertBox.exceptionAlert(e);
		}
		
	}
	
	public void cmdResults(ActionEvent event) {
		try {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Result.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (Exception e) {
			AlertBox.exceptionAlert(e);
		}
		
	}
	
	public void cmdProfile(ActionEvent event) {
		try {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Profile.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (Exception e) {
			AlertBox.exceptionAlert(e);
		}
		
	}
	
	public void cmdRanking(ActionEvent event) {
		try {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Ranking.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (Exception e) {
			AlertBox.exceptionAlert(e);
		}
		
	}
	
	public void cmdLogout(ActionEvent event){
		try {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Login.fxml"));
			rootPane.getChildren().setAll(newRoot);
		} catch (Exception e) {
			AlertBox.exceptionAlert(e);
		}
		
	}

}
