package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Model.Comms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class RevisionResultController implements Initializable{
	
	String Word;
	String Grade;
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private Label lblsomeWord;
	
	@FXML
	private Label lblquizGrade;
	
	@FXML
	private Label lblquizScore;
	
	
	@FXML
	void cmdExit(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	public void getGrade() {
		int score = Comms.getInstance().shareVar().getQuizScore();
		int num = Comms.getInstance().shareVar().getQuizNum();
		System.out.println(num);
		double percent = ((double)score / (double) num) * 100;
		System.out.println(percent + "% test");
		if (percent >= 80) {
			Word = "Exellent keep up the good work";
			Grade = "You got an A";
		} else if (percent >= 60 && percent < 80) {
			Word = "Keep it up";
			Grade = "You got a B";
		} else if (percent >= 40 && percent < 60) {
			Word = "You can do it";
			Grade = "You got a C";
		} else if (percent >= 30 && percent < 40){
			Word = "Don't give up, little bit more";
			Grade = "You got a D";
		}else {
			Word = "Don't give up";
			Grade = "You got a F";
		}

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String Score = Integer.toString(Comms.getInstance().shareVar().getQuizScore());
		String Num = Integer.toString(Comms.getInstance().shareVar().getQuizNum());
		getGrade();
		lblquizGrade.setText(Grade);
		lblsomeWord.setText(Word);
		lblquizScore.setText(Score + "/" + Num);
	}

}
