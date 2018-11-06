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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import application.Model.Comms;

public class QuizQuestionController implements Initializable {

	Random operation = new Random();
	Random number = new Random();
	Timer timer = new Timer();
	int score = 0;
	int ans;
	int oper = 0;
	int numOfQuiz = 0;

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
		
		
	}

	public void setQuizNum(int newNumQues) {
		numOfQuiz = newNumQues;
		System.out.println(numOfQuiz);
		for (int i = 1; i <= numOfQuiz; i++ ) {
			int addFirst = number.nextInt(35);
			int addSecond = number.nextInt(35);
			int fAns = addFirst + addSecond;
			lblQuestion.setText(addFirst + " + " + addSecond + " = ?");
			System.out.println("Test");
			System.out.println(numOfQuiz);
			
			btnNextQues.setOnAction(e->{
				String ans = tfAnswer.getText();
				System.out.println(ans);
				int newAns = Integer.parseInt(ans);
				System.out.println("test");
				if(newAns == fAns) {
					score ++;
				}
//				setQuizNum(numOfQuiz);
			});
		}
		
	}

//	public void initialize() {
//		// TODO Auto-generated method stub
//		Comms.getInstance().getQuizNum();
//		int addFirst = number.nextInt(35);
//		int addSecond = number.nextInt(35);
//		lblQuestion.setText(addFirst + " + " + addSecond + " = ?");
//		System.out.println("Test");
//		tfAnswer = new TextField();
//
//	}
}
