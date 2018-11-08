package application.Controller;

import java.io.*;
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
	    private Label dobStudent;
	    
	    @FXML
	    private Label dobParent;
	    
	    @FXML
	    private Label nameParent;
	    
	    @FXML
	    private Label contactParents;
	    

	    
	    @FXML
	    private Label address;
	    
	    @FXML
	    private Label emailStudent;
	    
	    @FXML
	    private Button editButton;
	    
	    //  @FXML
		  //  private Label icStudent;
	    
		 //   @FXML
		 //   private Label icParent;
		    

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
		int stdID = Comms.getInstance().shareVar().getID();
		System.out.println(stdID);
		StudentDB stdDB = new StudentDB();
		ParentDB prtDB = new ParentDB();
		
		stdDB.listAllStudentDebug();
		nameStudent.setText(stdDB.selectStudentWhereID(stdID).getName());
		emailStudent.setText(stdDB.selectStudentWhereID(stdID).getEmail());
		dobStudent.setText(stdDB.selectStudentWhereID(stdID).getDOB().toString());
		prtDB.listAllDebug();
		
		nameParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getName());
		contactParents.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getContact());
		address.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getAddress());
		dobParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getDOB().toString());
		
		
		// Discarded
//		icParent.setText(prtDB.selectParentWhereID(stdDB.selectStudentWhereID(stdID).getParentID()).getIC());
//		icStudent.setText(stdDB.selectStudentWhereID(stdID).getIC());
	
		
	}
	
	

}
