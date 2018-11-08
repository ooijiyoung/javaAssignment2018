package application.Controller;

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
    private TextField tfParentContact;

    @FXML
    private TextArea tfParentAddr;

    @FXML
    private TextField tfEmail;

    @FXML
    private DatePicker dpStdDob;

    @FXML
    private DatePicker dpParentDOB;

    @FXML
    private Button btnSubmit, btnCancel;

    @FXML
    void cmdRegister(ActionEvent event) {
    	boolean pwdMatch = false;
    	boolean verification = false;
    	String studentName = tfStdName.getText();
    	String password = pfPwd.getText();
    	String cfmPassword = pfConfirmPwd.getText();
//    	String studentIC = tfStdIC.getText();
    	String parentName = tfParentName.getText();
//    	String parentIC = tfParentIC.getText();
    	String parentAddr = tfParentAddr.getText();
    	String parentContact = tfParentContact.getText();
    	String stdEmail = tfEmail.getText();
    	LocalDate studentDOB = dpStdDob.getValue();
    	LocalDate parentDOB = dpParentDOB.getValue();
    	
    	
    	
    	if(studentName.isEmpty()) {
    		tfStdName.getStyleClass().add("is-invalid");
    		verification = false;
    	}else {
    		tfStdName.getStyleClass().setAll("text-input", "text-field" ,  "form-control","is-valid");
    		verification = true;
    	}
	  	if(stdEmail.isEmpty()) {
	  		tfEmail.getStyleClass().add("is-invalid");
				verification = false;
			}else {
				tfEmail.getStyleClass().setAll("text-input", "text-field" ,  "form-control","is-valid");
				verification = true;
			}
    	
//    	if(studentIC.isEmpty()) {
//    		tfStdIC.getStyleClass().add("is-invalid");
//    		verification = false;
//    	}else {
//    		tfStdIC.getStyleClass().setAll("text-input", "text-field" ,  "form-control","is-valid");
//    		verification = true;
//    	}
    	
    	if(parentName.isEmpty()) {
    		tfParentName.getStyleClass().add("is-invalid");
    		verification = false;
    	}else {
    		tfParentName.getStyleClass().setAll("text-input", "text-field" ,  "form-control","is-valid");
    		verification = true;
    	}
    	
//    	if(parentIC.isEmpty()) {
//    		tfParentIC.getStyleClass().add("is-invalid");
//    		verification = false;
//    	}else {
//    		tfParentIC.getStyleClass().setAll("text-input", "text-field" ,  "form-control","is-valid");
//    		verification = true;
//    	}
    	
    	if(parentAddr.isEmpty()) {
    		System.out.println(tfParentAddr.getStyleClass());
    		tfParentAddr.getStyleClass().add("is-invalid");
    		verification = false;
    	}else {
    		tfParentAddr.getStyleClass().setAll("text-input", "text-area","is-valid");
    		verification = true;
    	}

    	if(parentContact.isEmpty()) {
    		tfParentContact.getStyleClass().add("is-invalid");
    		verification = false;
    	}else {
    		tfParentContact.getStyleClass().setAll("text-input", "text-field" ,  "form-control","is-valid");
    		verification = true;
    	}
    	
    	if(dpStdDob.getValue() == null) {
    		dpStdDob.getStyleClass().add("is-invalid");
    		verification = false;
    	}else {
    		dpStdDob.getStyleClass().setAll("combo-box-base", "date-picker","is-valid");
    		verification = true;
    	}
    	
    	if(dpParentDOB.getValue() == null) {
    		dpParentDOB.getStyleClass().add("is-invalid");
    		verification = false;
    	}else {
    		dpParentDOB.getStyleClass().setAll("combo-box-base", "date-picker","is-valid");
    		verification = true;
    	}
    	
    	
    	if(!password.equals(cfmPassword) || password.isEmpty()) {
    		pfPwd.getStyleClass().add("is-invalid");
    		pfConfirmPwd.getStyleClass().add("is-invalid");
    		pwdMatch = false;
    	}else {
    		pwdMatch = true;
    		
    		pfPwd.getStyleClass().setAll("text-input", "text-field" , "password-field",  "form-control","is-valid");
    		pfConfirmPwd.getStyleClass().setAll("text-input", "text-field" , "password-field",  "form-control","is-valid");
    	}
    	
    	if(verification == true && pwdMatch==true) {
    		ParentDB prtDB = new ParentDB();
      	prtDB.add(parentName, parentDOB, parentContact, parentAddr);
      	int parentID = prtDB.getLastID();
      	
      	StudentDB stdDB = new StudentDB();
      	stdDB.add(studentName,studentDOB, stdEmail, password, parentID);
      	
      	stdDB.listAllStudentDebug();
      	
      	AlertBox.infoAlert("User Successfully Registered");
      	AnchorPane newRoot;
      	try {
  				newRoot = FXMLLoader.load(getClass().getResource("../Interface/Login.fxml"));
  				rootPane.getChildren().setAll(newRoot);
  	    	} catch (Exception e) {
  					AlertBox.exceptionAlert(e);
  	    	}    	
    	}else {
    		String errmsg = "Please make sure all the fields are filled.";
    		if(pwdMatch == false && verification == true) {
    			errmsg = "Password and Confirm Password does not match";
    		}
    		AlertBox.errorAlert(errmsg);
    	}
    	
    }
    @FXML
    void cmdCancel(ActionEvent event) {
    	try {
    		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Login.fxml"));
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
