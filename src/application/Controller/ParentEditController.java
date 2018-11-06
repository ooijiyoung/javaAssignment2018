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
    private Label icParent;
    
    @FXML
    private TextField addressField;
    
    @FXML
    private TextField contactField;
    
    @FXML
    private Button editButton;

    @FXML
    void doneEdit(ActionEvent event) throws IOException{
    	/*
    	 * append the database with the one just edited
    	 * 
    	 * 
    	 * 
    	 */
    	
    	String newAddressField = (addressField.getText()).toString();
    	String newcontactField = contactField.getText();
    	
    	System.out.println(newAddressField);
    	System.out.println(newcontactField);

    	
    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Profile.fxml"));
  		rootPane.getChildren().setAll(newRoot);
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
