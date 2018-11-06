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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class QuizNumberController implements Initializable{
	// Number of Question
		@FXML
		private AnchorPane rootPane;
	
		@FXML
		private Button btnStart;

		@FXML
		private RadioButton rb5;

		@FXML
		private RadioButton rb10;

		@FXML
		private RadioButton rb15;

		@FXML
		private RadioButton rb20;

		@FXML
		private RadioButton rb25;

		@FXML
		private ImageView imgBack;

		@FXML
		private Label lblNumQuestion;
		
		@FXML
		void cmdStart(ActionEvent event) throws IOException {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/EasyQ1.fxml"));
			rootPane.getChildren().setAll(newRoot);
//			RadioButton chk = (RadioButton) group1.getSelectedToggle();
//			int newNumQues = Integer.parseInt(chk.getText());
//			System.out.println(newNumQues);
	//
			
//			int addFirst = number.nextInt(35);
//			int addSecond = number.nextInt(35);
//			System.out.println(addFirst + " " + addSecond);
//			lblQuestion = new Label();
//			lblQuestion.setText(addFirst + " + " + addSecond + " = ?");
			//int addTotal = addFirst + addSecond;
			//String strAns = tfAnswer.getText();
			//int newAns = Integer.parseInt(strAns);
		}
		
		@FXML
		void cmdBack(MouseEvent event) throws IOException {
			AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Quiz.fxml"));
			rootPane.getChildren().setAll(newRoot);
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		
		

}
