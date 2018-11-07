package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;

import application.Model.Comms;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class QuizController implements Initializable {
	Random operation = new Random();
	Random number = new Random();
	Timer timer = new Timer();
	int score = 0;
	int ans;
	int oper = 0;

	// Quiz choosing difficulty
	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button btnNext;

	@FXML
	private ImageView imgHome;

	@FXML
	private Label lblQuiz;

	@FXML
	private RadioButton rbEasy;

	@FXML
	private RadioButton rbMedium;

	@FXML
	private RadioButton rbHard;
	
	@FXML
	private ToggleGroup group;

	@FXML
	void cmdHome(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdBack(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Quiz.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdNext(ActionEvent event) throws IOException {
//		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/QuizNumOfQuestion.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../Interface/QuizNumOfQuestion.fxml"));
		
		AnchorPane newRoot = loader.load();
		
		
		RadioButton chk = (RadioButton) group.getSelectedToggle();
		switch (chk.getText()) {
		case "Easy":
			Comms.getInstance().shareVar().setQuizDifficulty(0);;
			break;
		case "Medium":
			Comms.getInstance().shareVar().setQuizDifficulty(1);;
			break;
		case "Hard":
			Comms.getInstance().shareVar().setQuizDifficulty(2);;
			break;
		}
			
		
		

		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdExit(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}



	@Override	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
