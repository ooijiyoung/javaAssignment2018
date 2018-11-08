package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Database.ParentDB;
import application.Database.StudentDB;
import application.Model.Comms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ParentEditController implements Initializable  {
	StudentDB stdDB = new StudentDB();
	ParentDB prtDB = new ParentDB();
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
    private Label dobParent;
    
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
    private Label emailStudent;
    
    @FXML
    void cmdHome(MouseEvent event) throws IOException {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Info");
    	alert.setHeaderText("Are you sure you want to Go Homepage without saving?");
    	alert.setContentText("Choose your option.");

    	ButtonType buttonTypeOne = new ButtonType("Save & Exit");
    	ButtonType buttonTypeTwo = new ButtonType("Exit without Saving");
    	ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOne){
    		int stdID = Comms.getInstance().shareVar().getID();
        	String newAddressField = (addressField.getText()).toString();
        	String newcontactField = contactField.getText();
        	
        	System.out.println(newAddressField);
        	System.out.println(newcontactField);

        	prtDB.updateParentProfileByID(stdDB.selectStudentWhereID(stdID).getParentID(), newcontactField, newAddressField);
        	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
      		rootPane.getChildren().setAll(newRoot);
      		
    	} else if (result.get() == buttonTypeTwo) {
    		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
      		rootPane.getChildren().setAll(newRoot);
    	} else {
    	    // ... user chose CANCEL or closed the dialog
    	}
    	
    	
    	
    	/*
    	 * For now it saves when you clicked home. Time to do the pop out and say "Click to saves Changes"
    	 * 
    	 */
    	
    }

    @FXML
    void doneEdit(ActionEvent event) throws IOException{
    	/*
    	 * append the database with the one just edited
    	 * 
    	 * 
    	 * 
    	 */
    	
    	int stdID = Comms.getInstance().shareVar().getID();
    	String newAddressField = (addressField.getText()).toString();
    	String newcontactField = contactField.getText();
    	
    	System.out.println(newAddressField);
    	System.out.println(newcontactField);

    	prtDB.updateParentProfileByID(stdDB.selectStudentWhereID(stdID).getParentID(), newcontactField, newAddressField);
    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Profile.fxml"));
  		rootPane.getChildren().setAll(newRoot);
    }
    
    @FXML
    void cancelEdit(ActionEvent event) throws IOException{
    
    	
    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Profile.fxml"));
  		rootPane.getChildren().setAll(newRoot);
    }
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		int stdID = Comms.getInstance().shareVar().getID();
		System.out.println(stdID);
		
		
		stdDB.listAllStudentDebug();
		nameStudent.setText(stdDB.selectStudentWhereID(stdID).getName());
		dobStudent.setText(stdDB.selectStudentWhereID(stdID).getDOB().toString());
		emailStudent.setText(stdDB.selectStudentWhereID(stdID).getEmail());
		
		nameParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getName());
		addressField.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getAddress());
		contactField.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getContact());
		dobParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getDOB().toString());
		
		// Discarded
//		icParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getIC());
//		icStudent.setText(stdDB.selectStudentWhereID(stdID).getIC());
	}

}
