package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
