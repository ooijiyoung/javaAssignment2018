package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import application.Controller.QuizQuestionController.Question;
import application.Interface.AlertBox;
import application.Model.Comms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RevisionQuestionController implements Initializable {

	public class Question {
		private int questionNo;
		private String question;
		private int answer;
		private int userResponse;

		public Question(int qNo, String q, int a, int u) {
			questionNo = qNo;
			question = q;
			answer = a;
			userResponse = u;
		}

		public String getQuestion() {
			return question;
		}

		public int getUserResponse() {
			return userResponse;
		}

		public int getQuesNo() {
			return questionNo;
		}

		public int getAnswer() {
			return answer;
		}

		public void setUserResponse(int u) {
			userResponse = u;
		}

		public Boolean isCorrect() {
			if (userResponse == answer) {
				return true;
			} else {
				return false;
			}
		}

		public String toString() {
			return questionNo + question + "=" + answer + "" + userResponse;
		}

	}

	ArrayList<Question> quizHist = new ArrayList<Question>();
	Random operation = new Random();
	Random number = new Random();
	int count = 0;
	int numOfQuiz = 0;
	int score = 0;
	int fAns = 0;

	@FXML
	private Label lblRevisionQuesNo;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button btnNextQues;

	@FXML
	private Button btnPrev;

	@FXML
	private TextField tfAnswer;

	@FXML
	private Label lblQuestion;

	@FXML
	private Label lblAnswer;

	@FXML
	private Label lblQAnswer;

	@FXML
	void cmdExit(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	void cmdRA(ActionEvent event) throws IOException {

		lblAnswer.setText("Answer");
		String AnsStr = Integer.toString(quizHist.get(count).getAnswer());
		lblQAnswer.setText(AnsStr);
	}

	public void setQuizNum() throws IOException {
		numOfQuiz = Comms.getInstance().shareVar().getQuizNum();
		if (count < numOfQuiz) {
			lblRevisionQuesNo.setText("Revision Question " + (count + 1));

			setQuestion();
			lblQuestion.setText(quizHist.get(count).getQuestion());
			btnNextQues.setOnAction(e -> {
				lblQAnswer.setText("");
				lblAnswer.setText("");
				String ans = tfAnswer.getText();
				int newAns;
				if (!ans.isEmpty()) {
					try {
						newAns = Integer.parseInt(ans);
						// System.out.println("test");

						quizHist.get(count).setUserResponse(newAns);
						count++;
						System.out.println("Count: " + count);
						tfAnswer.clear();
						tfAnswer.setText("0");
						try {
							setQuizNum();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (Exception ex) {
						AlertBox.errorAlert("Please Enter Digit / Integer Only");
					}
				} else {
					AlertBox.errorAlert("Answer Field Cannot Be Blank");
				}
			});
		}

		else {
			for (int x = 0; x < quizHist.size(); x++) {
				System.out.println(quizHist.get(x));
				if (quizHist.get(x).isCorrect()) {
					score++;
				}
			}
			System.out.println("Your Score is: " + score);
			Comms.getInstance().shareVar().setQuizScore(score);
			System.out.println(Comms.getInstance().shareVar().getQuizScore());
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/RevisionResult.fxml"));
			rootPane.getChildren().setAll(newRoot);
			count = 0;
		}

	}

	@FXML
	public void cmdPrevious(ActionEvent event) {
		lblQAnswer.setText("");
		lblAnswer.setText("");
		if (count != 0) {
			try {
				int newAns = Integer.parseInt(tfAnswer.getText());
				quizHist.get(count).setUserResponse(newAns);
				count--;

				tfAnswer.setText(Integer.toString(quizHist.get(count).getUserResponse()));
				lblRevisionQuesNo.setText("Revision Question " + (count + 1));
				lblQuestion.setText(quizHist.get(count).getQuestion());
			} catch (Exception ex) {
				AlertBox.errorAlert("Please Enter Digit / Integer Only");
			}

		} else {
			AlertBox.infoAlert("This is the first question");
		}

	}

	public void setQuestion() {
		int diff = Comms.getInstance().shareVar().getQuizDifficulty();
		int first = 0, second = 0, oper = 0;
		String operandSymb = " ? ";
		// 0-add,1-sub,2-div,3-multi,4-all
		// for(int x=0;x<numOfQuiz;x++) {

		first = number.nextInt(35);
		second = number.nextInt(35);
		if (diff == 4) {
			oper = operation.nextInt(diff);
		} else {
			oper = diff;
		}
		switch (oper) {
		case 0: {
			fAns = first + second;
			operandSymb = " + ";
			break;
		}
		case 1: {
			while (second >= first) {
				second = number.nextInt(35);
			}
			operandSymb = " - ";
			fAns = first - second;
			break;
		}
		case 2: {
			first = number.nextInt(13);
			second = number.nextInt(13);
			fAns = first * second;
			operandSymb = " x ";
			break;
		}
		case 3: {
			first = number.nextInt(101);
			second = (number.nextInt(11) + 1);
			while (second % 2 != 0 || second == 0) {
				second = number.nextInt(11);
			}
			while (first % 2 != 0 || second > first) {
				first = number.nextInt(101);
			}
			operandSymb = " / ";
			fAns = first / second;
			break;
		}
		}
		// }
		String questionText = first + operandSymb + second + " = ?";

		quizHist.add(new Question((count + 1), questionText, fAns, 0));

	}
}
