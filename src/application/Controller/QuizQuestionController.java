package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class QuizQuestionController implements Initializable {

	Random operation = new Random();
	Random number = new Random();
	Timer timer = new Timer();
	int score = 0;
	int ans;
	int oper = 0;

	@FXML
	private AnchorPane rootPane;

	// Quiz Question
	@FXML
	private Button btnExit;

	@FXML
	private Label lblQuizQuesNo;

	@FXML
	private Label lblDifficulty;

	@FXML
	private Label lblQuestion;

	@FXML
	private TextField tfAnswer;

	@FXML
	private Text txtTimer;

	@FXML
	private Button btnPrevious;

	@FXML
	private Button btnNextQues;

	@FXML
	void cmdStart(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
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
		int addFirst = number.nextInt(35);
		int addSecond = number.nextInt(35);
		lblQuestion.setText(addFirst + " + " + addSecond + " = ?");
		System.out.println("Test");
		tfAnswer = new TextField();
		
		QuizNumberController qz = new QuizNumberController();
		System.out.println(qz.newNumOutside);

	}

	public void initialize() {
		// TODO Auto-generated method stub
		int addFirst = number.nextInt(35);
		int addSecond = number.nextInt(35);
		lblQuestion.setText(addFirst + " + " + addSecond + " = ?");
		System.out.println("Test");
		tfAnswer = new TextField();

	}
}
