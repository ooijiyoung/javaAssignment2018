package application.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ParentEditController implements Initializable  {

	@FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView imgHome;
    
    @FXML
    private Label nameStudent;
    
    @FXML
    private Label icStudent;
    
    @FXML
    private Label dobStudent;
    
    @FXML
    private Label nameParent;
    
    @FXML
    private TextField contactParentField;
    
    @FXML
    private Label icParent;
    
    @FXML
    private TextField addressField;
    
    @FXML
    private Button editButton;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
