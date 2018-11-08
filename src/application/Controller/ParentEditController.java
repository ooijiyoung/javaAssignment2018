package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Database.ParentDB;
import application.Database.StudentDB;
import application.Model.Comms;
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
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		int stdID = Comms.getInstance().shareVar().getID();
		System.out.println(stdID);
		
		
		stdDB.listAllStudentDebug();
		nameStudent.setText(stdDB.selectStudentWhereID(stdID).getName());
		dobStudent.setText(stdDB.selectStudentWhereID(stdID).getDOB().toString());
		nameParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getName());
		addressField.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getAddress());
		contactField.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getContact());
		emailStudent.setText(stdDB.selectStudentWhereID(stdID).getEmail());
		
		
		// Discarded
//		icParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getIC());
//		icStudent.setText(stdDB.selectStudentWhereID(stdID).getIC());
	}

}
