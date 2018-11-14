package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import application.Interface.AlertBox;
import application.Model.Comms;


public class QuizQuestionController implements Initializable {
	
	public class Question{
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
		
		public String getQuestion() {return question;}
		public int getUserResponse(){return userResponse;}
		public int getQuesNo() {return questionNo;}
		
		public void setUserResponse(int u) {userResponse = u;}
		
		public Boolean isCorrect() { 
			if(userResponse == answer) {
				return true;
			}else {
				return false;
			}
		}
		
		public String toString() {return questionNo + question + "=" + answer + "" + userResponse;}
		
		
	}
	
	ArrayList<Question> quizHist = new ArrayList<Question>();
	
	Random operation = new Random();
	Random number = new Random();
	Timer timer = new Timer();
	int score = 0;
	int ans;
	int oper = 0;
	int numOfQuiz = 0;
	int count = 0;
	int fAns = 0;
	String Diff;

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
			
			
			if(count>=quizHist.size()) {
				fAns = setQuestion();
			}else {
				tfAnswer.setText(Integer.toString(quizHist.get(count).getUserResponse()));
				lblQuizQuesNo.setText("Quiz Question " + (count + 1));
				lblQuestion.setText(quizHist.get(count).getQuestion());
			}
			

			btnNextQues.setOnAction(e -> {
				String ans = tfAnswer.getText();
				int newAns;
				if(!ans.isEmpty()) {
					try {
						newAns = Integer.parseInt(ans);
					// System.out.println("test");
						System.out.println(quizHist.size());
						if(count>=quizHist.size()) {
							quizHist.add(new Question((count+1),lblQuestion.getText().toString(),fAns,newAns));
						}else {
							quizHist.get(count).setUserResponse(newAns);
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
			
			for(int x=0;x<quizHist.size();x++) {
				System.out.println(quizHist.get(x));
				if(quizHist.get(x).isCorrect()) {
					
					score++;
				}
			}
			System.out.println("Your Score is: " + score);
			Comms.getInstance().shareVar().setQuizScore(score);
			System.out.println(Comms.getInstance().shareVar().getQuizScore());
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/AfterQuizResult.fxml"));
			rootPane.getChildren().setAll(newRoot);
		}

	}
	
	@FXML
	public void cmdPrevious(ActionEvent event) {
		if(count!=0) {
			count--;
			
			tfAnswer.setText(Integer.toString(quizHist.get(count).getUserResponse()));
			lblQuizQuesNo.setText("Quiz Question " + (count + 1));
			lblQuestion.setText(quizHist.get(count).getQuestion());
		}else {
			AlertBox.infoAlert("This is the first question");
		}
		
	}

	public int setQuestion() {
		int fAns = 0;
		int diff = Comms.getInstance().shareVar().getQuizDifficulty();
		int operandControl = 1;
		switch (diff) {
			case 0: {
				Diff = "Easy";
				lblDifficulty.getStyleClass().add("text-success");
				break;
			}
			case 1: {
				Diff = "Medium";
				lblDifficulty.getStyleClass().add("text-warning");
				operandControl = 2;
				break;
			}
			case 2: {
				Diff = "Hard";
				lblDifficulty.getStyleClass().add("text-danger");
				operandControl = 4;
				break;
			}
		}
		
		lblDifficulty.setText(Diff);
		lblQuizQuesNo.setText("Quiz Question " + (count + 1));
		
		
		int oper = operation.nextInt(operandControl);
		String operandSymb = "?";
		int first = number.nextInt(35);
		int second = number.nextInt(35);
		
		switch(oper) {
			case 0: {
				fAns = first + second;
				operandSymb = " + ";
				break;
			}
			case 1:{
				while (second >= first) {
					second = number.nextInt(35);
				}
				operandSymb = " - ";
				fAns = first - second;
				break;
			}
			case 2:{
				first = number.nextInt(13);
				second = number.nextInt(13);
				fAns = first * second;
				operandSymb = " x ";
				break;
			}
			case 3:{
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
		
		lblQuestion.setText(first + operandSymb + second + " = ?");
		
		
		
		return fAns;
	}
}
