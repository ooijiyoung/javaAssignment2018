package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
	
	//Quiz choosing difficulty 
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

	//Number of Question
	@FXML
	private Button btnStart;
	
	@FXML
	private RadioButton rb5;
	
	@FXML
	private RadioButton rb10;
	
	@FXML
	private RadioButton rb15;
	
	@FXML
	private RadioButton rb20;
	
	@FXML
	private RadioButton rb25;
	
	@FXML
	private ImageView imgBack;
	
	@FXML
	private Label lblNumQuestion;
	
	//Quiz Question
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
	void cmdHome(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdStart(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/EasyQ1.fxml"));
		rootPane.getChildren().setAll(newRoot);
		if (rbEasy.isSelected()) {
			
			
			for (int i = 1; i <= QuesNo; i++) {
				oper = operation.nextInt(1);
				switch (oper) {
				case 0:
					int addFirst = number.nextInt(35);
					int addSecond = number.nextInt(35);
					System.out.println(i + ") " + addFirst + " + " + addSecond + " = ?");
					int addTotal = addFirst + addSecond;
					ans = 0;
					System.out.print("Answer: ");
					ans = kbInput.nextInt();
					if (ans == addTotal) {
						score++;
						System.out.println("correct");
					} else {
						System.out.println("Wrong the correct answer is " + addTotal);
					}
					break;
				}
			}
		}
		else if (rbMedium.isSelected()) {
			
		}
		else if (rbHard.isSelected()) {
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
