package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class QuizController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button btnStart;

	@FXML
	private ImageView imgHome;
	
	@FXML
	private RadioButton Easy00;
	
	@FXML
	private RadioButton Medium01;
	
	@FXML
	private RadioButton Hard02;
	
	@FXML
	private Label QuizNum00;
	
	@FXML
	private Button Exit00;
	
	@FXML
	private Label Difficulty00;
	
	@FXML
	private Label Question000;
	
	@FXML
	private Button Previous00;
	
	@FXML
	private Label Next00;
	
	@FXML
	private Text Timer00;
	
	@FXML
	private TextField ShortAnswer00;

	@FXML
	void cmdHome(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}

	@FXML
	void cmdStart(ActionEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/EasyQ1.fxml"));
		rootPane.getChildren().setAll(newRoot);
		if (Easy00.isSelected()) {
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
