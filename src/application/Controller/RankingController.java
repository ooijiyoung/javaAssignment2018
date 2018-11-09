package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Database.ResultDB;
import application.Database.StudentDB;
import application.Model.Result;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class RankingController implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView imgHome;
    
    @FXML
    private GridPane gpRanking;
    
    @FXML
    private ComboBox<String> cbDiff;
    
    int count = 1;

    
    ObservableList<String> diffList = (ObservableList<String>) FXCollections.observableArrayList("Easy", "Medium", "Hard");

    @FXML
    void cmdHome(MouseEvent event) throws IOException {
    	AnchorPane newRoot = FXMLLoader.load(getClass().getResource("../Interface/Main.fxml"));
  		rootPane.getChildren().setAll(newRoot);
    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			String diff = cbDiff.getValue();
			ResultDB result = new ResultDB();
			StudentDB student = new StudentDB();
			ArrayList<Result> resultlist;
			resultlist = result.selectResultWhereDiff(diff);
						
			cbDiff.setValue("Easy");
			cbDiff.setItems(diffList);
			
			cbDiff.valueProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					// TODO Auto-generated method stub
				
					for (int x = 0; x < resultlist.size(); x++) {
						
						String newcount = new Integer(count).toString();
						Label numLbl = new Label(newcount);
						Label nameLbl = new Label(student.selectStudentWhereID(resultlist.get(x).getStdID()).getName());
						Label diffLbl = new Label(resultlist.get(x).getDiff());
//						Label gradeLbl = new Label(resultlist.get(x).getGrade());
						
						
						gpRanking.add(numLbl, 0, count);
						gpRanking.add(numLbl, 1, count);
						gpRanking.add(diffLbl, 2, count);

					
						count++;

					}
				}    
		    });
			
			int x = application.Model.Comms.getInstance().shareVar().getID();
			System.out.println(x);
		}

}
