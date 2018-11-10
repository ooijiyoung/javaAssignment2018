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
			gpRanking.getChildren().retainAll(gpRanking.getChildren().get(0),gpRanking.getChildren().get(1),gpRanking.getChildren().get(2));
			int count = 0;
			int stdID = Comms.getInstance().shareVar().getID();
			ResultDB result = new ResultDB();
			StudentDB student = new StudentDB();
			ArrayList<Result> resultlist;
//			result.listAllDebug();
			resultlist = result.selectResultWhereDiff(diff);
			System.out.println(resultlist.size());
			for (int x = 0; x < resultlist.size(); x++) {
				System.out.println("test");
				String newcount = new Integer(count).toString();
				Label numLbl = new Label(newcount);
				System.out.println(resultlist.get(x).getStdID());
				Label name = new Label(student.selectStudentWhereID(resultlist.get(x).getStdID()).getName());
				
				gpRanking.add(numLbl, 0, (count+1));
				gpRanking.add(name, 1, (count+1));
				count++;
			}
			
			break;
		}
		case "Medium":{
			diff = "Medium";
			gpRanking.getChildren().retainAll(gpRanking.getChildren().get(0),gpRanking.getChildren().get(1),gpRanking.getChildren().get(2));
			int count = 0;
			int stdID = Comms.getInstance().shareVar().getID();
			ResultDB result = new ResultDB();
			StudentDB student = new StudentDB();
			ArrayList<Result> resultlist;
//			result.listAllDebug();
			resultlist = result.selectResultWhereDiff(diff);
			System.out.println(resultlist.size());
			for (int x = 0; x < resultlist.size(); x++) {
				System.out.println("test");
				String newcount = new Integer(count).toString();
				Label numLbl = new Label(newcount);
				Label name = new Label(student.selectStudentWhereID(resultlist.get(x).getStdID()).getName());
				
				gpRanking.add(numLbl, 0, (count+1));
				gpRanking.add(name, 1, (count+1));
				count++;
			}
			break;
		}
		case "Hard":{
			gpRanking.getChildren().retainAll(gpRanking.getChildren().get(0),gpRanking.getChildren().get(1),gpRanking.getChildren().get(2));
			diff = "Hard";
			int count = 0;
			int stdID = Comms.getInstance().shareVar().getID();
			ResultDB result = new ResultDB();
			StudentDB student = new StudentDB();
			ArrayList<Result> resultlist;
//			result.listAllDebug();
			resultlist = result.selectResultWhereDiff(diff);
			System.out.println(resultlist.size());
			for (int x = 0; x < resultlist.size(); x++) {
				System.out.println("test");
				String newcount = new Integer(count).toString();
				Label numLbl = new Label(newcount);
				Label name = new Label(student.selectStudentWhereID(resultlist.get(x).getStdID()).getName());
				
				gpRanking.add(numLbl, 0, (count+1));
				gpRanking.add(name, 1, (count+1));
				count++;
			}
			break;
		}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cbDiff.setItems(diffList);
//		String selected = cbDiff.getValue().toString();
//		System.out.println(selected+"test");
//		int count = 0;
//		int stdID = Comms.getInstance().shareVar().getID();
//		ResultDB result = new ResultDB();
//		StudentDB student = new StudentDB();
//		ArrayList<Result> resultlist;
//		result.listAllDebug();
//		resultlist = result.selectResultWhereDiff(selected);
//		System.out.println(resultlist.size());
//		for (int x = 0; x < resultlist.size(); x++) {
//			System.out.println("test");
//			String newcount = new Integer(count).toString();
//			Label numLbl = new Label(newcount);
//			Label name = new Label(student.selectStudentWhereID(resultlist.get(x).getStdID()).getName());
//			
//			gpRanking.add(numLbl, 0, count);
//			gpRanking.add(name, 1, count);
//			count ++;
//		}
		

//		int x = application.Model.Comms.getInstance().shareVar().getID();
//		System.out.println(x);
	}

}
