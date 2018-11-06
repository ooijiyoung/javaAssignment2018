package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;

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
	Random operation = new Random();
	Random number = new Random();
	Timer timer = new Timer();
	int score = 0;
	int ans;
	int oper = 0;
	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button btnNext;
	
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
	private ImageView Back00;
	
	@FXML
	private Label QuizNum00;
	
	@FXML
	private Label Quiz00;
	
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
	private RadioButton Num5;
	
	@FXML
	private RadioButton Num10;
	
	@FXML
	private RadioButton Num15;
	
	@FXML
	private RadioButton Num20;
	
	@FXML
	private RadioButton Num25;
	
	@FXML
	private Label NumQuesTitle00;
	
	

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
			
			
			for (int i = 1; i <= QuesNo; i++) {
				oper = operation.nextInt(1);
				switch (oper) {
				case 0:
					int addFirst = number.nextInt(35);
					int addSecond = number.nextInt(35);
					System.out.println(i + ") " + addFirst + " + " + addSecond + " = ?");
					int addTotal = addFirst + addSecond;
					ans = 0;
					System.out.print("Answer: ");
					ans = kbInput.nextInt();
					if (ans == addTotal) {
						score++;
						System.out.println("correct");
					} else {
						System.out.println("Wrong the correct answer is " + addTotal);
					}
					break;
				}
			}
		}
		else if (Medium01.isSelected()) {
			
		}
		else if (Hard02.isSelected()) {
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
