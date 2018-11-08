package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Model.Comms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RevisionController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Label lblQuizQuesNo;

	@FXML
	private Label lblQuestion;

	@FXML
	private TextField tfAnswer;

	@FXML
	private Button btnNextQues;

	@FXML
	private Button btnStart;

	@FXML
	private Button btnPrevious;

	@FXML
	private ToggleGroup tgQuestionNum;

	@FXML
	void cmdExit(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	@FXML
	void cmdBack(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/RevisionMenu.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdStart(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../Interface/RevisionQ1.fxml"));
		AnchorPane newRoot = loader.load();

		RadioButton chk = (RadioButton) tgQuestionNum.getSelectedToggle();
		String quizNum = chk.getText();
		switch (quizNum) {
		case "10": {
			System.out.println("test 10");
			Comms.getInstance().shareVar().setQuizNum(10);
			RevisionQuestionController quizCtrl = loader.getController();
			quizCtrl.setQuizNum();
			break;
		}
		case "15": {
			System.out.println("test 15");
			Comms.getInstance().shareVar().setQuizNum(15);
			RevisionQuestionController quizCtrl = loader.getController();
			quizCtrl.setQuizNum();
			break;
		}
		case "20": {
			Comms.getInstance().shareVar().setQuizNum(20);
			RevisionQuestionController quizCtrl = loader.getController();
			quizCtrl.setQuizNum();
			break;
		}
		case "25": {
			Comms.getInstance().shareVar().setQuizNum(25);
			RevisionQuestionController quizCtrl = loader.getController();
			quizCtrl.setQuizNum();
			break;
		}
		}

		rootPane.getChildren().setAll(newRoot);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
