package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RankingController implements Initializable{

    @FXML
    private AnchorPane rootPane;

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
