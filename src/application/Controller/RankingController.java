package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Database.ResultDB;
import application.Database.StudentDB;
import application.Model.Comms;
import application.Model.Result;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class RankingController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private ImageView imgHome;

	@FXML
	private GridPane gpRanking;

	@FXML
	private ComboBox<String> cbDiff;
	
	String diff;

	ObservableList<String> diffList = FXCollections.observableArrayList("Easy", "Medium", "Hard");

	@FXML
	void cmdHome(MouseEvent event) throws IOException {
		AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
		rootPane.getChildren().setAll(newRoot);
	}
	
	@FXML
	void cmdChange(ActionEvent event) throws IOException {
		String selected = cbDiff.getValue().toString();
		System.out.println(selected);
		switch(selected) {
		case "Easy":{
			diff = "Easy";
			break;
		}
		case "Medium":{
			diff = "Medium";
			break;
		}
		case "Hard":{
			diff = "Hard";
			break;
		}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cbDiff.setItems(diffList);
		cbDiff.setValue("Easy");
		String selected = cbDiff.getValue().toString();
		int count = 1;
		System.out.println(selected+"test");
		
		int stdID = Comms.getInstance().shareVar().getID();
		ResultDB result = new ResultDB();
		ArrayList<Result> resultlist;
		resultlist = result.selectResultWhereDiff(selected);
		System.out.println(resultlist.size());
		for (int x = 0; x < resultlist.size(); x++) {
			System.out.println("test");
			String newcount = new Integer(count).toString();
			Label numLbl = new Label(newcount);
			gpRanking.add(numLbl, 0, count);
		}
		

//		int x = application.Model.Comms.getInstance().shareVar().getID();
//		System.out.println(x);
	}

}
