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
	int count = 0;

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
		System.out.println("Quiz diffuculty is :" + Comms.getInstance().shareVar().getQuizDifficulty());
	}

	public void setQuizNum(int newNumQues) throws IOException {
		numOfQuiz = newNumQues;
		Comms.getInstance().shareVar().setQuizNum(numOfQuiz);

		if (count < numOfQuiz) {

			int fAns = setQuestion();

			btnNextQues.setOnAction(e -> {
				String ans = tfAnswer.getText();
				int newAns = Integer.parseInt(ans);
				// System.out.println("test");
				if (newAns == fAns) {
					score++;
				}
				count++;
				System.out.println("Count: " + count);
				tfAnswer.clear();
				tfAnswer.setText("0");
				try {
					setQuizNum(numOfQuiz);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

//				setQuizNum(numOfQuiz);
			});
		}

		else {
			System.out.println("Your Score is: " + score);
			Comms.getInstance().shareVar().setQuizScore(score);
			System.out.println(Comms.getInstance().shareVar().getQuizScore());
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/AfterQuizResult.fxml"));
			rootPane.getChildren().setAll(newRoot);
		}

	}

	public int setQuestion() {
		int fAns = 0;
		int diff = Comms.getInstance().shareVar().getQuizDifficulty();
		switch (diff) {
		case 0: {
			int First = number.nextInt(35);
			int Second = number.nextInt(35);
			fAns = First + Second;
			lblQuestion.setText(First + " + " + Second + " = ?");
		}
		case 1: {
			int oper = operation.nextInt(2);

			switch (oper) {
			case 0: {
				int First = number.nextInt(35);
				int Second = number.nextInt(35);
				fAns = First + Second;
				lblQuestion.setText(First + " + " + Second + " = ?");
				break;
			}
			case 1: {
				int First = number.nextInt(35);
				int Second = number.nextInt(35);
				while (Second >= First) {
					Second = number.nextInt(35);
				}
				fAns = First - Second;
				lblQuestion.setText(First + " - " + Second + " = ?");
				break;
			}
			}
			break;
		}
		case 2: {
			int oper = operation.nextInt(4);

			switch (oper) {
			case 0: {
				int First = number.nextInt(35);
				int Second = number.nextInt(35);
				fAns = First + Second;
				lblQuestion.setText(First + " + " + Second + " = ?");
				break;
			}
			case 1: {
				int First = number.nextInt(35);
				int Second = number.nextInt(35);
				while (Second >= First) {
					Second = number.nextInt(35);
				}
				while (Second >= First) {
					Second = number.nextInt(35);
				}

				fAns = First - Second;
				lblQuestion.setText(First + " - " + Second + " = ?");
				break;
			}
			case 2: {
				int First = number.nextInt(13);
				int Second = number.nextInt(13);
				fAns = First * Second;
				lblQuestion.setText(First + " x " + Second + " = ?");
				break;
			}
			case 3: {
				int First = number.nextInt(101);
				int Second = number.nextInt(11);
				while (Second % 2 != 0 || Second == 0) {
					Second = number.nextInt(11);
				}
				while (First % 2 != 0 || Second > First) {
					First = number.nextInt(101);
				}
				
				fAns = First / Second;
				lblQuestion.setText(First + " / " + Second + " = ?");
				break;
			}
			}
		}
			break;
		}
		return fAns;
	}
}
