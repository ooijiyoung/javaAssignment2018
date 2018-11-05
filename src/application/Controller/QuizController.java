package application.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class QuizController {
	
	@FXML
	private AnchorPane rootPane;
	
  @FXML
  private Button btnStart;

  @FXML
  void cmdStart(ActionEvent event) throws IOException {
  	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
  }
}
