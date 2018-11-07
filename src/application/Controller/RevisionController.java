package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RevisionController implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private RadioButton rbRev5;

    @FXML
    private RadioButton rbRev10;

    @FXML
    private RadioButton rbRev20;

    @FXML
    private Button btnRevStart;

    @FXML
    private ImageView imgHome;

    @FXML
    void cmdHome(MouseEvent event) throws IOException {
    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
  		rootPane.getChildren().setAll(newRoot);
    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

}

/*		Random operation = new Random();
		Random number = new Random();
		int score = 0;
		int count = 0;
		int ans;

		System.out.println("How many questions? :");
		Scanner keyboard = new Scanner(System.in);
		int QuestionNo = keyboard.nextInt();

		for (int i = 1; i <= QuestionNo; i++) {
			int oper = operation.nextInt(1);
			switch (oper) {
			case 0:
				int addFirst = number.nextInt(35);
				int addSecond = number.nextInt(35);
				System.out.println(i + ")" + addFirst + " + " + addSecond + "= ?");
				count++;
				int addTotal = addFirst + addSecond;
				ans = 0;
				System.out.println("Answer:");
				ans = keyboard.nextInt();
				if (ans == addTotal) {
					System.out.println("That is correct!");
					score++;
				} else {
					System.out.println("That is incorrect. The answer is " + addTotal);
				}
			case 1:
				int subFirst = number.nextInt(35);
				int subSecond = number.nextInt(35);
				while (subSecond >= subFirst) {
					subSecond = number.nextInt(35);
				}
				System.out.println(i + ")" + subFirst + " - " + subSecond + "= ?");
				count++;
				int subTotal = subFirst - subSecond;
				ans = 0;
				System.out.println("Answer:");
				ans = keyboard.nextInt();
				if (ans == subTotal) {
					System.out.println("That is correct!");
					score++;
				} else {

					System.out.println("That is incorrect. The answer is " + subTotal);
				}

			case 2:
				int mulFirst = number.nextInt(35);
				int mulSecond = number.nextInt(35);
				System.out.println(i + ")" + mulFirst + " * " + mulSecond + "= ?");
				count++;
				int mulTotal = mulFirst * mulSecond;
				ans = 0;
				System.out.println("Answer:");
				ans = keyboard.nextInt();
				if (ans == mulTotal) {
					System.out.println("That is correct!");
					score++;
				} else {

					System.out.println("That is incorrect. The answer is " + mulTotal);
				}

			case 3:
				int divFirst = number.nextInt(144);
				int divSecond = number.nextInt(12);
				while ((divSecond == 0) || (divSecond >= divFirst)) {
					divSecond = number.nextInt(12);
				}
				System.out.println(i + ")" + divFirst + " / " + divSecond + "= ?");
				count++;
				int divTotal = divFirst / divSecond;
				ans = 0;
				System.out.println("Answer:");
				ans = keyboard.nextInt();
				if (ans == divTotal) {
					System.out.println("That is correct!");
					score++;
				} else {

					System.out.println("That is incorrect. The answer is " + divTotal);
				}
				break;

			}
			System.out.println("You got " + score + " correct answers out of " + count);
		}
		
	}

}
*/
