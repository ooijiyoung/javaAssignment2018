package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Database.ResultDB;
import application.Model.Comms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class QuizResultController implements Initializable {

	String Diff;
	String Grade;
	String GradeWord;
	String Word;
	@FXML
	private Button btnExit;
	@FXML
	private Label lblquizDiff;
	@FXML
	private Label lblsomeWord;
	@FXML
	private Label lblquizGrade;
	@FXML
	private Label lblquizScore;
	@FXML
	private AnchorPane rootPane;

	@FXML
	void cmdExit(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	public void getDiff() {
		int diff = Comms.getInstance().shareVar().getQuizDifficulty();
		switch (diff) {
		case 0: {
			Diff = "Easy";
			break;
		}
		case 1: {
			Diff = "Medium";
			break;
		}
		case 2: {
			Diff = "Hard";
			break;
		}
		}
	}

	public void getGrade() {
		int score = Comms.getInstance().shareVar().getQuizScore();
		int num = Comms.getInstance().shareVar().getQuizNum();
		System.out.println(num);
		double percent = ((double)score / (double) num) * 100;
		System.out.println(percent + "% test");
		if (percent >= 80) {
			Word = "Exellent keep up the good work";
			GradeWord = "You got an A";
			Grade="A";
		} else if (percent >= 60 && percent < 80) {
			Word = "Keep it up";
			GradeWord = "You got a B";
			Grade="B";
		} else if (percent >= 40 && percent < 60) {
			Word = "You can do it";
			GradeWord = "You got a C";
			Grade="C";
		} else if (percent >= 30 && percent < 40){
			Word = "Don't give up, little bit more";
			GradeWord = "You got a D";
			Grade="D";
		}else {
			Word = "Don't give up";
			GradeWord = "You got a F";
			Grade="F";
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		int stdID = Comms.getInstance().shareVar().getID();
		ResultDB result = new ResultDB();
		
		
		getDiff();
		String Score = Integer.toString(Comms.getInstance().shareVar().getQuizScore());
		String Num = Integer.toString(Comms.getInstance().shareVar().getQuizNum());
		getGrade();
		lblquizGrade.setText(GradeWord);
		lblsomeWord.setText(Word);
		lblquizDiff.setText(Diff);
		lblquizScore.setText(Score + "/" + Num);
		String anyname = (Score + "/" + Num);
		result.add(stdID, anyname, Diff, Grade);
	}

}
