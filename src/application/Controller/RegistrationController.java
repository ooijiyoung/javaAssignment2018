package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Database.ParentDB;
import application.Database.StudentDB;
import application.Interface.AlertBox;
public class RegistrationController  implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField tfStdName;

    @FXML
    private PasswordField pfPwd;

    @FXML
    private PasswordField pfConfirmPwd;

    @FXML
    private TextField tfParentName;

    @FXML
    private TextField tfParentIC;

    @FXML
    private TextField tfParentContact;

    @FXML
    private TextArea tfParentAddr;

    @FXML
    private TextField tfStdIC;

    @FXML
    private DatePicker dpStdDob;

    @FXML
    private DatePicker dpParentDOB;

    @FXML
    private Button btnSubmit;

    @FXML
    void cmdRegister(ActionEvent event) {
    	boolean pwdMatch = false;
    	
    	String studentName = tfStdName.getText();
    	String password = pfPwd.getText();
    	String cfmPassword = pfConfirmPwd.getText();
    	String studentIC = tfStdIC.getText();
    	String parentName = tfParentName.getText();
    	String parentIC = tfParentIC.getText();
    	String parentAddr = tfParentAddr.getText();
    	String parentContact = tfParentContact.getText();
    	LocalDate studentDOB = dpStdDob.getValue();
    	LocalDate parentDOB = dpParentDOB.getValue();
    	
    	if(password.equals(cfmPassword)) {
    		pwdMatch = true;
    	}
    	
    	ParentDB prtDB = new ParentDB();
    	prtDB.add(parentName, parentDOB, parentIC, parentContact, parentAddr);
    	int parentID = prtDB.getLastID();
    	
    	StudentDB stdDB = new StudentDB();
    	stdDB.add(studentName,studentDOB, studentIC, password, parentID);
    	
    	stdDB.listAllStudentDebug();
    	
    	AlertBox.infoAlert();
    	AnchorPane newRoot;
    	try {
			newRoot = FXMLLoader.load(getClass().getResource("../Interface/Login.fxml"));
			rootPane.getChildren().setAll(newRoot);
    	} catch (Exception e) {
				AlertBox.exceptionAlert(e);
    	}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
