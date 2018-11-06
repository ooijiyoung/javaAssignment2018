package application.Controller;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ProfileController implements Initializable {

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
	    private Label contactParents;
	    
	    @FXML
	    private Label icParent;
	    
	    @FXML
	    private Label address;
	    
	    @FXML
	    private Button editButton;

	    @FXML
	    void cmdHome(MouseEvent event) throws IOException {
	    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
	  		rootPane.getChildren().setAll(newRoot);
	    }
	
	  @FXML
	    void editProfile(ActionEvent event) throws IOException{
	    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/ProfileEdit.fxml"));
	  		rootPane.getChildren().setAll(newRoot);
	    }
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	nameStudent.setText("Test");
	icStudent.setText("Test");
	dobStudent.setText("Test");
	nameParent.setText("Test");
	contactParents.setText("Test");
	icParent.setText("Test");
	address.setText("Test");
	
	}
	
	

}
