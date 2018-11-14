package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

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
		String AnsStr = Integer.toString(fAns);
		lblQAnswer.setText(AnsStr);
	}

	public void setQuizNum() throws IOException {
		numOfQuiz = Comms.getInstance().shareVar().getQuizNum();
		if (count < numOfQuiz) {

			int fAns = setQuestion();

			btnNextQues.setOnAction(e -> {
				String ans = tfAnswer.getText();
				int newAns;
				if(!ans.isEmpty()) {
					try {
						newAns = Integer.parseInt(ans);
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
					}catch(Exception ex){
						AlertBox.errorAlert("Please Enter Digit / Integer Only");
					}
				}else {
					AlertBox.errorAlert("Answer Field Cannot Be Blank");
				}

			});
		}

		else {
			System.out.println("Your Score is: " + score);
			Comms.getInstance().shareVar().setQuizScore(score);
			System.out.println(Comms.getInstance().shareVar().getQuizScore());
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/RevisionResult.fxml"));
			rootPane.getChildren().setAll(newRoot);
			count = 0;
		}

	}

	public int setQuestion() {
		lblRevisionQuesNo.setText("Revision Question " + (count + 1));
		int oper = Comms.getInstance().shareVar().getQuizDifficulty();

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
		case 4:{
			int operations = operation.nextInt(4);

			switch (operations) {
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
				int Second = (number.nextInt(11) + 1);
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
		}
		return fAns;
	}
}
