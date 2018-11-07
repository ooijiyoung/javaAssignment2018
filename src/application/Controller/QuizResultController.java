package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		getDiff();
		String Score = Integer.toString(Comms.getInstance().shareVar().getQuizDifficulty());
		String Num = Integer.toString( Comms.getInstance().shareVar().getQuizNum());
		lblquizDiff.setText(Diff);
		lblquizScore.setText(Score + "/" +Num);
	}

}
