package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

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
	void cmdExit(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void setQuizNum() throws IOException {
		numOfQuiz = Comms.getInstance().shareVar().getQuizNum();
		if (count < numOfQuiz) {

			int fAns = setQuestion();

			btnNextQues.setOnAction(e -> {
				String ans = tfAnswer.getText();
				int newAns = Integer.parseInt(ans);
				if (newAns == fAns) {
					score++;
				}
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

			});
		}

		else {
			System.out.println("Your Score is: " + score);
			Comms.getInstance().shareVar().setQuizScore(score);
			System.out.println(Comms.getInstance().shareVar().getQuizScore());
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/RevisionResult.fxml"));
			rootPane.getChildren().setAll(newRoot);
		}

	}

	public int setQuestion() {
		int fAns = 0;
		lblRevisionQuesNo.setText("Revision Question " + (count + 1));
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
		return fAns;
	}
}
