package application.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Database.ParentDB;
import application.Database.StudentDB;

public class RegistrationController  implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField tfStdName;

    @FXML
    private TextField tfStdPwd;

    @FXML
    private TextField tfStdConfirmPwd;

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
    	String studentName = tfStdName.getText();
    	String password = tfStdPwd.getText();
    	String cfmPassword = tfStdConfirmPwd.getText();
    	String studentIC = tfStdIC.getText();
    	String parentName = tfParentName.getText();
    	String parentIC = tfParentIC.getText();
    	String parentAddr = tfParentAddr.getText();
    	String parentContact = tfParentContact.getText();
    	LocalDate studentDOB = dpStdDob.getValue();
    	LocalDate parentDOB = dpParentDOB.getValue();
    	
    	
    	ParentDB prtDB = new ParentDB();
    	prtDB.add(parentName, parentDOB, parentIC, parentContact, parentAddr);
    	int parentID = prtDB.getLastID();
    	
    	StudentDB stdDB = new StudentDB();
    	stdDB.add(studentName,studentDOB, studentIC, password, parentID);
    	
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
