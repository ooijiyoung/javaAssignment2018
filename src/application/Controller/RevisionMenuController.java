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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RevisionMenuController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private ImageView imgHome;

	@FXML
	private Label lblTitleRevision;

	@FXML
	private Button btnNext;

	@FXML
	private ToggleGroup groupMenu;

	@FXML
	void cmdHome(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdStart(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdBack(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Quiz.fxml"));
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

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../Interface/Revision.fxml"));

		AnchorPane newRoot = loader.load();

		RadioButton chk = (RadioButton) groupMenu.getSelectedToggle();
		switch (chk.getText()) {
		case "Addition":{
			Comms.getInstance().shareVar().setQuizDifficulty(0);
			System.out.println("test add");
			break;
		}
			
		case "Subtraction":
			Comms.getInstance().shareVar().setQuizDifficulty(1);
			;
			break;
		case "Multiplication":
			Comms.getInstance().shareVar().setQuizDifficulty(2);
			;
			break;
		case "Division":
			Comms.getInstance().shareVar().setQuizDifficulty(3);
			;
			break;
		case "All":
			Comms.getInstance().shareVar().setQuizDifficulty(4);
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
