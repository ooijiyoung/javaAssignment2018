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
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class RevisionMenuController implements Initializable{
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private ImageView imgHome;
	
	@FXML
	private Label lblTitleRevision;
	
	@FXML
	private RadioButton rbAddition;
	
	@FXML
	private RadioButton rbSubtraction;
	
	@FXML
	private RadioButton rbMultiplication;
	
	@FXML
	private RadioButton rbDivision;
	
	@FXML
	private Button btnNext;
	
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
	
	@FXML
	void cmdNext(ActionEvent event) throws IOException {
//		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/QuizNumOfQuestion.fxml"));

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../Interface/QuizNumOfQuestion.fxml"));

		AnchorPane newRoot = loader.load();

		RadioButton chk = (RadioButton) groupMenu.getSelectedToggle();
		switch (chk.getText()) {
		case "Easy":
			Comms.getInstance().shareVar().setQuizDifficulty(0);
			;
			break;
		case "Medium":
			Comms.getInstance().shareVar().setQuizDifficulty(1);
			;
			break;
		case "Hard":
			Comms.getInstance().shareVar().setQuizDifficulty(2);
			;
			break;
		}

		rootPane.getChildren().setAll(newRoot);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
